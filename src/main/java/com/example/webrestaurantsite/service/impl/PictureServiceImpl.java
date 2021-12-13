package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.entity.Picture;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.User;
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

    @Override
    public void initializePicture() {
        if (pictureRepository.count() == 0) {
            Picture picture = new Picture();
            User user = userRepository.findUserByUsername("dimitar");
            Restaurant restaurant = restaurantRepository.findByOwner(user);
            picture.setImageURL("https://rezzo.bg/files/images/26694/fit_431_304.jpg")
                    .setRestaurant(restaurant);
            pictureRepository.save(picture);
        }

    }
}
