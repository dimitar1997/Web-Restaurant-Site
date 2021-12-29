package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.BidingModels.AddRestaurantBidingModel;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.Town;
import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.service.AddRestaurantServiceModel;
import com.example.webrestaurantsite.models.view.RestaurantViewDetailsModel;
import com.example.webrestaurantsite.repository.RestaurantRepository;
import com.example.webrestaurantsite.repository.TownRepository;
import com.example.webrestaurantsite.repository.UserRepository;
import com.example.webrestaurantsite.service.RestaurantService;
import com.example.webrestaurantsite.service.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;
    private final TownService townService;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, UserRepository userRepository, ModelMapper modelMapper, TownRepository townRepository, TownService townService) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
        this.townService = townService;
    }


    @Override
    public RestaurantViewDetailsModel details(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.getById(restaurantId);
        return modelMapper.map(restaurant, RestaurantViewDetailsModel.class);
    }

    @Override
    public void addRestaurant(AddRestaurantBidingModel addRestaurantBidingModel, UserDetailsImpl currentUser) throws IOException {
        AddRestaurantServiceModel addRestaurantServiceModel = modelMapper.map(addRestaurantBidingModel, AddRestaurantServiceModel.class);
        Restaurant restaurant = modelMapper.map(addRestaurantServiceModel, Restaurant.class);
        User owner = userRepository.findByUsername(currentUser.getUserIdentifier());
        restaurant.setOwner(owner);
        Town town = townRepository.findByCity(addRestaurantServiceModel.getTown());
        restaurant.setCity(town);

        restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

    public boolean isOwner(String userName, Long id) {
        User user = userRepository.findByUsername(userName);
        Restaurant restaurant = restaurantRepository.getById(id);
        if (user.getUsername().equals(restaurant.getOwner().getUsername())) {
            return true;
        }
        return false;
    }
}
