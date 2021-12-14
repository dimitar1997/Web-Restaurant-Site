package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.repository.PictureRepository;
import com.example.webrestaurantsite.repository.RestaurantRepository;
import com.example.webrestaurantsite.repository.UserRepository;
import com.example.webrestaurantsite.service.PictureService;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public PictureServiceImpl(PictureRepository pictureRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }


}
