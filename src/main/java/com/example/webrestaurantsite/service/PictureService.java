package com.example.webrestaurantsite.service;

import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.service.AddPictureServiceModel;

import java.io.IOException;

public interface PictureService {
    void addPicture(AddPictureServiceModel addPictureServiceModel, Restaurant restaurant) throws IOException;

}
