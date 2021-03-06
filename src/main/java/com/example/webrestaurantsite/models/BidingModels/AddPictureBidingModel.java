package com.example.webrestaurantsite.models.BidingModels;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;

public class AddPictureBidingModel {
    private MultipartFile image;

    @NotNull
    public MultipartFile getImage() {
        return image;
    }

    public AddPictureBidingModel setImage(MultipartFile image) {
        this.image = image;
        return this;
    }
}
