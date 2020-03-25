/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.profile;

import com.donatedrop.articles.PhoneNumber;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

/**
 *
 * @author G7
 */
@Entity
public class ProfileBasic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(max = 256)
    @Column(name = "user_id")
    private String userId;
    
    @Size(max = 512)
    @Column(name = "name")
    private String name;
    
    @Size(max = 512)
    @Column(name = "birth_date")
    private String birthDate;
    
    @Size(max = 1024)
    @Column(name = "care_of")
    private String care_of;
    
    @Size(max = 512)
    @Column(name = "gender")
    private String gender;
    
    @Size(max = 256)
    @Column(name = "marital_status")
    private String maritalStatus;
    
    @Size(max = 256)
    @Column(name = "profession")
    private String profession;
    
    @Column(name = "blood_Group")
    private String blood_Group;
    
    @Column(name = "available")
    private String available;
    
    @OneToOne
    @JoinColumn(name = "address_permanent")
    private Address address_permanent;
    
    @OneToOne
    @JoinColumn(name = "address_current")
    private Address address_current;
    
    @OneToMany
    @JoinColumn(name = "phone_number") 
    private List<PhoneNumber> phone_number;
    
    @OneToMany
    @JoinColumn(name = "emergency_contact") 
    private List<EmergencyContact> emergency_contact;
        
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfileBasic)) {
            return false;
        }
        ProfileBasic other = (ProfileBasic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donatedrop.profile.Profile_Basic[ id=" + id + " ]";
    }
    
}