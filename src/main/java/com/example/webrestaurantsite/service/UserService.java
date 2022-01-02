package com.example.webrestaurantsite.service;

import com.example.webrestaurantsite.models.BidingModels.RegisterBidingModel;

public interface UserService {

    void addUser(RegisterBidingModel registerBidingModel);

    boolean isUserNameFree(String userName);
}
