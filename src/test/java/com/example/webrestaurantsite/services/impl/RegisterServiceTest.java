package com.example.webrestaurantsite.services.impl;

import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.entity.enums.RoleEnums;
import com.example.webrestaurantsite.repository.UserRepository;
import com.example.webrestaurantsite.service.impl.WebRestaurantImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;

import java.util.stream.Collectors;


@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {
    private User testUser;


    private WebRestaurantImpl serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void init() {

        //ARRANGE
        serviceToTest = new WebRestaurantImpl(mockUserRepository);



        testUser = new User();
        testUser.setUsername("dimitar");
        testUser.setFirstName("test1");
        testUser.setMiddleName("");
        testUser.setLastName("test2");
        testUser.setEmail("dimitar@abv.bgtest");
        testUser.setPassword("123456");
        testUser.setRole(RoleEnums.OWNER);
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> serviceToTest.loadUserByUsername("invalid_user")
        );
    }

    @Test
    void testUserFound() {

        // Arrange
        Mockito.when(mockUserRepository.findByUsername(testUser.getUsername())).
                thenReturn(testUser);

        // Act
        var actual = serviceToTest.loadUserByUsername(testUser.getUsername());

        // Assert

        String expectedRoles = "ROLE_OWNER";
        String actualRoles = actual.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(
                Collectors.joining(", "));

        Assertions.assertEquals(actual.getUsername(), testUser.getUsername());
        Assertions.assertEquals(expectedRoles, actualRoles);
    }

}
