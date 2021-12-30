package com.example.webrestaurantsite.models.service;

import javax.validation.constraints.NotNull;
import java.io.File;

public class AddPictureViewModel {
    private File image;


    public File getImage() {
        return image;
    }

    public AddPictureViewModel setImage(File image) {
        this.image = image;
        return this;
    }
}
