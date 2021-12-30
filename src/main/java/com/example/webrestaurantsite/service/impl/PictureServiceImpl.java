package com.example.webrestaurantsite.service.impl;


import com.example.webrestaurantsite.models.entity.Picture;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.service.AddPictureViewModel;
import com.example.webrestaurantsite.repository.PictureRepository;
import com.example.webrestaurantsite.repository.RestaurantRepository;
import com.example.webrestaurantsite.service.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final RestaurantRepository restaurantRepository;


    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, RestaurantRepository restaurantRepository) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public void addPicture(AddPictureViewModel addPictureViewModel, Restaurant restaurant) {
        Picture picture = modelMapper.map(addPictureViewModel, Picture.class);

        picture.setRestaurant(restaurant);
        pictureRepository.save(picture);
    }
}
