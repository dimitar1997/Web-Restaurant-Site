package com.example.webrestaurantsite.services.impl;

import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.Town;
import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.entity.enums.RoleEnums;
import com.example.webrestaurantsite.repository.RestaurantRepository;

import com.example.webrestaurantsite.service.RestaurantService;
import com.example.webrestaurantsite.web.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class RestaurantServiceImplTest {

    private Town testTown;
    private User testUser;



    @Mock
    private RestaurantRepository testRestaurantRepo;

    @Mock
    private RestaurantService restaurantService;

    private Restaurant testRestaurant;

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


        testRestaurant = new Restaurant();
        testRestaurant.setId(1);
        testRestaurant.setOwner(testUser);
        testRestaurant.setAddress("test-address");
        testRestaurant.setName("test");

        testTown = new Town();
        testTown.setCity("Sofia");
        testRestaurant.setCity(testTown);


        testRestaurant.setCapacity(100);
        testRestaurant.setDescription("test-test-test-test-test-test-test-test-test-test-test-test-test-test-test-test-");





    }

    @Test
    void testRegisterRestaurant() {

        Mockito.when(testRestaurantRepo.findById(1L)).thenReturn(java.util.Optional.ofNullable(testRestaurant));

        var actual = testRestaurantRepo.findById(1L);

        Assertions.assertEquals(actual.get().getId(), testRestaurant.getId());
        Assertions.assertEquals(actual.get().getCity().getCity(), testRestaurant.getCity().getCity());
        Assertions.assertEquals(actual.get().getAddress(), testRestaurant.getAddress());
        Assertions.assertEquals(actual.get().getCapacity(), testRestaurant.getCapacity());
        Assertions.assertEquals(actual.get().getName(), testRestaurant.getName());
        Assertions.assertEquals(actual.get().getDescription(), testRestaurant.getDescription());
        Assertions.assertEquals(actual.get().getOwner(), testRestaurant.getOwner());

    }

    @Test
    void testRestaurantNotFound() {
        Assertions.assertThrows(
                ObjectNotFoundException.class,
                () -> restaurantService.findRestaurantById(2L)
        );
    }


}
