/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.security.controller;

import com.donatedrop.security.models.AuthenticationRequest;
import com.donatedrop.security.models.AuthenticationResponse;
import com.donatedrop.security.models.User;
import com.donatedrop.security.repo.UserRepository;
import com.donatedrop.security.service.MyUserDetailsService;
import com.donatedrop.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author G7
 */
@RestController
class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @RequestMapping({"/hello"})
    public String firstPage() {
        return "<h1>SpringBoot-JWT-JPA</h1>";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public Map<String, String> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequest)
            throws AuthenticationException {
        Map<String, String> map = new HashMap<>();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            /**
             * tried other ways but failed.
             */
            e.printStackTrace();
            map.put("status", "FAIL");
            map.put("message", "Incorrect username or password");
            return ResponseEntity.ok(map);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        map.put("status", "OK");
        map.put("message", jwt);
        return ResponseEntity.ok(map);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken2(@RequestBody AuthenticationRequest authenticationRequest)
            throws AuthenticationException, Exception {
        try {
            System.out.println("\n\n passwordEncoder : " + passwordEncoder.toString());
            System.out.println("\n\n Name : " + authenticationRequest.getUsername());
            System.out.println("\n\n Pass : " + authenticationRequest.getPassword());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new ExceptionLoggin("");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @PostMapping("register")
    public Map<String, String> register(@RequestBody User u) {
        System.out.println("User : " + u.toString());
//        System.out.println("Done -- User : " + u.toString());
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setUserName(u.getUserName());
        u.setEnabled(Boolean.TRUE);
        u.setAuthorities(new ArrayList<>());
        userRepository.save(u);
        Map<String, String> map = new HashMap<>();
        final UserDetails userDetails = userDetailsService.loadUserByUsername(u.getUserName());
        final String token = jwtTokenUtil.generateToken(userDetails);
        map.put("status", "OK");
        map.put("token", token);
        map.put("user_name", u.getUserName());
        return map;
    }

}
