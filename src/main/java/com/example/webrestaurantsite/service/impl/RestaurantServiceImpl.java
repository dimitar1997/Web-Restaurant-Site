package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.BidingModels.AddRestaurantBidingModel;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.view.RestaurantViewDetailsModel;
import com.example.webrestaurantsite.repository.RestaurantRepository;
import com.example.webrestaurantsite.repository.UserRepository;
import com.example.webrestaurantsite.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, UserRepository userRepository,ModelMapper modelMapper) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public RestaurantViewDetailsModel details(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.getById(restaurantId);
        return modelMapper.map(restaurant, RestaurantViewDetailsModel.class);
    }

    @Override
    public void addRestaurant(AddRestaurantBidingModel addRestaurantBidingModel, UserDetailsImpl currentUser) {
        Restaurant restaurant = modelMapper.map(addRestaurantBidingModel, Restaurant.class);
        User owner = userRepository.findByUsername(currentUser.getUserIdentifier());
        restaurant.setOwner(owner);
        restaurantRepository.save(restaurant);
    }
}
