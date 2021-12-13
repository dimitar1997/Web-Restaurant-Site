package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.repository.RestaurantRepository;
import com.example.webrestaurantsite.repository.UserRepository;
import com.example.webrestaurantsite.service.RestaurantService;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void initializeRestaurant() {
        if (restaurantRepository.count() == 0){
            Restaurant restaurant = new Restaurant();
            restaurant.setAddress("krusim 18")
                    .setName("Djani")
                    .setDescription("mnogo qko")
                    .setOwner(userRepository.findUserByUsername("dimitar"))
                    .setSeats(200);
            restaurantRepository.save(restaurant);
        }

    }
}
