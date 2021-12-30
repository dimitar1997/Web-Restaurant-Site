package com.example.webrestaurantsite.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.File;

@Entity
@Table(name = "pictures")
public class Picture extends BasicEntity {
    private File image;
    private Restaurant restaurant;

    @ManyToOne
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Picture setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    @Column
    public File getImage() {
        return image;
    }

    public Picture setImage(File image) {
        this.image = image;
        return this;
    }
}
