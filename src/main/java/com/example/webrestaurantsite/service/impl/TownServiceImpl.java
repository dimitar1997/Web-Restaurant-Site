package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.Town;
import com.example.webrestaurantsite.repository.RestaurantRepository;
import com.example.webrestaurantsite.repository.TownRepository;
import com.example.webrestaurantsite.service.TownService;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final RestaurantRepository restaurantRepository;

    public TownServiceImpl(TownRepository townRepository, RestaurantRepository restaurantRepository) {
        this.townRepository = townRepository;
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public void add(String townName, UserDetailsImpl currentUser) {
        Restaurant restaurant = restaurantRepository.findByOwnerUsername(currentUser.getUserIdentifier());
        Town town = townRepository.findByName(townName);
        if (town == null) {
            Town newTown = new Town().setName(townName);
        } else {
            restaurant.setTown(town);
        }
    }
}
