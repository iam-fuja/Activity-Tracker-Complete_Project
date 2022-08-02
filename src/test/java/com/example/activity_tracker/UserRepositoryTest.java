package com.example.activity_tracker;


import com.example.activity_tracker.model.User;
import com.example.activity_tracker.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepo;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void testCreateUser(){
//        User user = new User();
//        user.setEmail("augustaeshiowula@gmail.com");
//        user.setPassword("Chijindu99");
//        user.setFirstName("Jindu");
//        user.setLastName("Eshio");
//
//        User savedUser = userRepo.save(user);
//
//        User existUser = entityManager.find(User.class, savedUser.getId());
//
//        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
//    }
//}
