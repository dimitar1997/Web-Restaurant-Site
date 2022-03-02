package com.example.webrestaurantsite.services.impl;

import com.example.webrestaurantsite.models.entity.Picture;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.Town;
import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.entity.enums.RoleEnums;
import com.example.webrestaurantsite.repository.PictureRepository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PictureServiceImplTest {
    private String PUBLIC_ID = "test2";


    private Town testTown;
    private User testUser;
    private Restaurant testRestaurant;
    private Picture testPicture;

    @Mock
    PictureRepository testPictureRepository;


    @BeforeEach
    void init() {
        testPicture = new Picture();
        testPicture.setId(2L);
        testPicture.setImageUrl("https://images.unsplash.com/photo-1508921912186-1d1a45ebb3c1?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGhvdG98ZW58MHx8MHx8&w=1000&q=80");
        testPicture.setPublicId(PUBLIC_ID);

        testUser = new User();
        testUser.setUsername("dimitar");
        testUser.setFirstName("test1");
        testUser.setMiddleName("");
        testUser.setLastName("test2");
        testUser.setEmail("dimitar@abv.bgtest");
        testUser.setPassword("123456");
        testUser.setRole(RoleEnums.OWNER);


        testRestaurant = new Restaurant();
        testRestaurant.setId(1L);
        testRestaurant.setOwner(testUser);
        testRestaurant.setAddress("test-address");
        testRestaurant.setName("test");

        testTown = new Town();
        testTown.setCity("Sofia");
        testRestaurant.setCity(testTown);


        testRestaurant.setCapacity(100);
        testRestaurant.setDescription("test-test-test-test-test-test-test-test-test-test-test-test-test-test-test-test-");

        testPicture.setRestaurant(testRestaurant);
    }
// not working
    @Test
    void testPictureFound(){
        Mockito.when(testPictureRepository.findById(2L)).thenReturn(java.util.Optional.ofNullable(testPicture));


        var actual = testPictureRepository.findByRestaurantId(testRestaurant.getId());
        Assertions.assertEquals(actual.getId(), testPicture.getId());
    }
}
