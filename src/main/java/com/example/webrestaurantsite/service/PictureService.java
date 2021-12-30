package com.example.webrestaurantsite.service;

import com.example.webrestaurantsite.models.BidingModels.AddPictureBidingModel;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.service.AddPictureViewModel;

public interface PictureService {
    void addPicture(AddPictureViewModel addPictureViewModel, Restaurant restaurant);

}
