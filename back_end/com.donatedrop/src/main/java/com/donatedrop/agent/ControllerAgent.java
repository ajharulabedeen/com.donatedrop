/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author G7
 */
@RestController
@RequestMapping("/public/user/")
public class ControllerAgent {

    @Autowired
    Service_Agent_I service_Agent_I;

    @PostMapping("saveRequest")
    public Map<String, String> saveRequest(@RequestBody AgentRequest agentRequest) {
        return service_Agent_I.saveRequest(agentRequest);
    }

}