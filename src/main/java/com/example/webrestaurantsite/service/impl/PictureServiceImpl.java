package com.example.webrestaurantsite.service.impl;



import com.example.webrestaurantsite.models.entity.Picture;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.service.AddPictureServiceModel;
import com.example.webrestaurantsite.repository.PictureRepository;
import com.example.webrestaurantsite.service.CloudinaryService;
import com.example.webrestaurantsite.service.PictureService;

import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final CloudinaryService cloudinaryService;

    public PictureServiceImpl(PictureRepository pictureRepository,CloudinaryService cloudinaryService) {
        this.pictureRepository = pictureRepository;
        this.cloudinaryService = cloudinaryService;
    }


    @Override
    public void addPicture(AddPictureServiceModel addPictureServiceModel, Restaurant restaurant) throws IOException {

        Picture picture = new Picture();



        final CloudinaryImage uploaded = this.cloudinaryService.upload(addPictureServiceModel.getImage());
        picture.setPublicId(uploaded.getPublicId()).setImageUrl(uploaded.getUrl());
        picture.setRestaurant(restaurant);
        pictureRepository.save(picture);
    }
}
