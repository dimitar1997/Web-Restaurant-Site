package com.example.webrestaurantsite.models.service;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class AddPictureServiceModel {
    private MultipartFile image;

    @NotNull
    public MultipartFile getImage() {
        return image;
    }

    public AddPictureServiceModel setImage(MultipartFile image) {
        this.image = image;
        return this;
    }
}
