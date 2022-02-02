package com.example.webrestaurantsite.web;

import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserRegisterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;


    @Test
    void test_Register_CreatesNewUser() throws Exception {
        mockMvc
                .perform(post("/users/register")
                        .param("firstName", "Test1")
                        .param("middleName", "")
                        .param("lastName", "Test2")
                        .param("username", "Test")
                        .param("email", "Test@abv.bg")
                        .param("password", "12345")
                        .param("confirmPassword", "12345")
                        .param("role", "OWNER")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users/login"));

        assertEquals(1, userRepository.count());
        User user = userRepository.findByUsername("Test");

        assertEquals("Test", user.getUsername());

    }
}
