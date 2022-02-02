package com.example.webrestaurantsite.services.impl;

import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.entity.enums.RoleEnums;
import com.example.webrestaurantsite.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class RegisterServiceTest {
    @Autowired
    UserRepository userRepository;


    @BeforeEach
    void init(){
        userRepository.deleteAll();
    }

    @AfterEach
    void delete() {
        userRepository.deleteAll();
    }
    @Test
    void registerUser(){
        User user = new User();

        user.setUsername("test123")
                .setEmail("test@hbasd.vf")
                .setRole(RoleEnums.OWNER)
                .setPassword("12345")
                .setFirstName("Test1")
                .setLastName("test 2")
                .setMiddleName("");
        userRepository.save(user);

        Assertions.assertEquals(1, userRepository.count());
        User user1 = userRepository.findByUsername("test123");

        Assertions.assertEquals("test123", user1.getUsername());
    }


}
