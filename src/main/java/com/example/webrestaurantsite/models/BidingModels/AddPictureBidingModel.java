package com.example.webrestaurantsite.models.BidingModels;

import javax.validation.constraints.NotNull;
import java.io.File;

public class AddPictureBidingModel {
    private File image;

    @NotNull
    public File getImage() {
        return image;
    }

    public AddPictureBidingModel setImage(File image) {
        this.image = image;
        return this;
    }
}
