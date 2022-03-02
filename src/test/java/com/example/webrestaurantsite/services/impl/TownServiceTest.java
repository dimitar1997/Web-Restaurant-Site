package com.example.webrestaurantsite.services.impl;

import com.example.webrestaurantsite.models.entity.Town;
import com.example.webrestaurantsite.models.view.AllTownsViewModel;
import com.example.webrestaurantsite.repository.TownRepository;
import com.example.webrestaurantsite.service.TownService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TownServiceTest {

    Town testTown;

    @Mock
    TownRepository testTownRepo;
    @Mock
    TownService testTownService;

    @BeforeEach
    void init(){
        testTown = new Town();
        testTown.setCity("Karlovo");
        testTown.setId(1L);
    }

// Not working
    @Test
    void ifTownExist(){
        Mockito.when(testTownRepo.findByCity("Karlovo")).thenReturn(testTown);

        var actual = testTownService.getAllTowns();
        for (AllTownsViewModel t :  actual) {
            if (t.getCity().equals(testTown.getCity())){
                Assertions.assertEquals(t.getCity(), testTown.getCity());
            }
        }


    }

}
