/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent.donner.models;

import com.donatedrop.profile.model.PhoneNumber;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author G7
 */
@Entity
@Table(name = "donner_to_agent_request_review")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DonnerToAgentRequestToReview.findAll", query = "SELECT d FROM DonnerToAgentRequestToReview d")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByProfileId", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.profileId = :profileId")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByName", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.name = :name")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByGender", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.gender = :gender")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByProfession", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.profession = :profession")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByUserId", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.userId = :userId")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByAddressPermanent", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.addressPermanent = :addressPermanent")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByAddressPresent", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.addressPresent = :addressPresent")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByRequestId", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.requestId = :requestId")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByRequestDate", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.requestDate = :requestDate")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByAcceptDate", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.acceptDate = :acceptDate")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByRejectDate", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.rejectDate = :rejectDate")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByRemoveDate", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.removeDate = :removeDate")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByStatus", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.status = :status")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentId", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentId = :presentId")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentDiv", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentDiv = :presentDiv")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentDist", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentDist = :presentDist")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentUpz", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentUpz = :presentUpz")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentUnion", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentUnion = :presentUnion")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentStreet", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentStreet = :presentStreet")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByUsername", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.username = :username")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentId", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentId = :permanentId")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentDiv", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentDiv = :permanentDiv")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentDist", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentDist = :permanentDist")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentUpz", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentUpz = :permanentUpz")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentUnion", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentUnion = :permanentUnion")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentStreet", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentStreet = :permanentStreet")})
public class DonnerToAgentRequestToReview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "profile_id")
    private long profileId;
    @Column(name = "available")
    private String available;
    @Column(name = "birth_date")
    private String birthDate;
    @Column(name = "blood_Group")
    private String bloodGroup;
    @Column(name = "care_of")
    private String careOf;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "marital_status")
    private String maritalStatus;
    @Column(name = "name")
    private String name;
    @Column(name = "profession")
    private String profession;
    @Column(name = "religion")
    private String religion;
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @Column(name = "request_donner_to_agent_id")
    private long requestDonnerToAgentId;
    @Column(name = "accept_date")
    private String acceptDate;
    @Lob
    @Column(name = "note_agent")
    private String noteAgent;
    @Lob
    @Column(name = "note_agent_personal")
    private String noteAgentPersonal;
    @Lob
    @Column(name = "note_donner")
    private String noteDonner;
    @Column(name = "reject_date")
    private String rejectDate;
    @Column(name = "remove_date")
    private String removeDate;
    @Column(name = "request_date")
    private String requestDate;
    @Column(name = "status")
    private String status;
    @Column(name = "user_id_donner")
    private String userIdDonner;
    @Column(name = "USERNAME")
    private String username;

    public DonnerToAgentRequestToReview() {
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCareOf() {
        return careOf;
    }

    public void setCareOf(String careOf) {
        this.careOf = careOf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getRequestDonnerToAgentId() {
        return requestDonnerToAgentId;
    }

    public void setRequestDonnerToAgentId(long requestDonnerToAgentId) {
        this.requestDonnerToAgentId = requestDonnerToAgentId;
    }

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getNoteAgent() {
        return noteAgent;
    }

    public void setNoteAgent(String noteAgent) {
        this.noteAgent = noteAgent;
    }

    public String getNoteAgentPersonal() {
        return noteAgentPersonal;
    }

    public void setNoteAgentPersonal(String noteAgentPersonal) {
        this.noteAgentPersonal = noteAgentPersonal;
    }

    public String getNoteDonner() {
        return noteDonner;
    }

    public void setNoteDonner(String noteDonner) {
        this.noteDonner = noteDonner;
    }

    public String getRejectDate() {
        return rejectDate;
    }

    public void setRejectDate(String rejectDate) {
        this.rejectDate = rejectDate;
    }

    public String getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(String removeDate) {
        this.removeDate = removeDate;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserIdDonner() {
        return userIdDonner;
    }

    public void setUserIdDonner(String userIdDonner) {
        this.userIdDonner = userIdDonner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
