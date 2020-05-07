package com.donatedrop.other;

import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.security.models.User;
import com.donatedrop.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Component
public class TestGenerelDao {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public List<ProfileBasic> getAllProfileBasic() {
        String q = "SELECT * FROM `profilebasic`";
        List<ProfileBasic> basicList =
                entityManager.createNativeQuery(q, ProfileBasic.class)
                        .setFirstResult(0)
                        .setMaxResults(10)
                        .getResultList();
        return basicList;
    }

}
