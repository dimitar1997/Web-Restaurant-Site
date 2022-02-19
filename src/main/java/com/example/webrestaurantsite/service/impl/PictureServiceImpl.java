package com.example.webrestaurantsite.service.impl;


import com.cloudinary.Cloudinary;
import com.example.webrestaurantsite.models.entity.Picture;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.service.AddPictureServiceModel;
import com.example.webrestaurantsite.repository.PictureRepository;
import com.example.webrestaurantsite.repository.RestaurantRepository;
import com.example.webrestaurantsite.service.CloudinaryService;
import com.example.webrestaurantsite.service.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final RestaurantRepository restaurantRepository;
    private final CloudinaryService cloudinaryService;
    private final String imagesPATH = "images/";
    private final String staticPath = "/resources/static/";

    private long index = 1;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, RestaurantRepository restaurantRepository, CloudinaryService cloudinaryService) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.restaurantRepository = restaurantRepository;
        this.cloudinaryService = cloudinaryService;
    }


    @Override
    public void addPicture(AddPictureServiceModel addPictureServiceModel, Restaurant restaurant) throws IOException {

        Picture picture = new Picture();

//        String insertPath = addPictureServiceModel.getImage().getOriginalFilename();
//        String imagePath = imagesPATH + index + insertPath;
//        String pathToSave = staticPath + imagePath;
//
//        File imageForSave = new File(pathToSave);
//        FileOutputStream fot = new FileOutputStream(imageForSave);
//        fot.write(addPictureServiceModel.getImage().getBytes());
//        fot.close();
//
//
//        picture.setImageUrl(imagePath);
//        index++;



        final CloudinaryImage uploaded = this.cloudinaryService.upload(addPictureServiceModel.getImage());
        picture.setPublicId(uploaded.getPublicId()).setImageUrl(uploaded.getUrl());
        picture.setRestaurant(restaurant);
        pictureRepository.save(picture);
    }
}
