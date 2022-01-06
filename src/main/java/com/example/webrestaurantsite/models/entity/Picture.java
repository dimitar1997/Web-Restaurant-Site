package com.example.webrestaurantsite.models.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "pictures")
public class Picture extends BasicEntity {
    private String imageUrl;
    private Restaurant restaurant;
    private String publicId;

    public String getPublicId() {
        return publicId;
    }

    public Picture setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    @ManyToOne
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Picture setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Picture setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
