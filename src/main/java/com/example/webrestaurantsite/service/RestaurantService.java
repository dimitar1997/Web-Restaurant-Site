package com.example.webrestaurantsite.service;

import com.example.webrestaurantsite.models.BidingModels.AddRestaurantBidingModel;
import com.example.webrestaurantsite.models.view.RestaurantViewDetailsModel;
import com.example.webrestaurantsite.service.impl.UserDetailsImpl;

public interface RestaurantService {
    RestaurantViewDetailsModel details(Long restaurantId);

    void addRestaurant(AddRestaurantBidingModel addRestaurantBidingModel, UserDetailsImpl currentUser);

    void delete(Long id);
}
