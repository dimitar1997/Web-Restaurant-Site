package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.entity.enums.RoleEnums;
import com.example.webrestaurantsite.repository.UserRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "OWNER")
public class OwnerControllerTest {
    private User testUser;


    @Autowired
    private UserRepository userRepository;




    @BeforeEach
    void init() {

        testUser = new User();
        testUser.setUsername("dimitar");
        testUser.setFirstName("test1");
        testUser.setMiddleName("");
        testUser.setLastName("test2");
        testUser.setEmail("dimitar@abv.bgtest");
        testUser.setPassword("123456");
        testUser.setRole(RoleEnums.OWNER);
        userRepository.save(testUser);
    }

    @AfterEach
    void delete() {
        userRepository.deleteAll();
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_GetHomePage() throws Exception {
        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }
}
