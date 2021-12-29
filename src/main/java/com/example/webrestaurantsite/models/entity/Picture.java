package com.example.webrestaurantsite.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BasicEntity {
    private String image;
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
    public String getImage() {
        return image;
    }

    public Picture setImage(String image) {
        this.image = image;
        return this;
    }
}
