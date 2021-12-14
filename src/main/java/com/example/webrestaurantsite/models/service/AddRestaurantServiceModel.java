package com.example.webrestaurantsite.models.service;

import com.example.webrestaurantsite.models.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddRestaurantServiceModel {
    private String name;
    private String description;
    private String address;
    private User owner;
    private int seats;
    private String town;


    public String getTown() {
        return town;
    }

    public AddRestaurantServiceModel setTown(String town) {
        this.town = town;
        return this;
    }


    public String getName() {
        return name;
    }

    public AddRestaurantServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddRestaurantServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }


    public String getAddress() {
        return address;
    }

    public AddRestaurantServiceModel setAddress(String address) {
        this.address = address;
        return this;
    }


    public User getOwner() {
        return owner;
    }

    public AddRestaurantServiceModel setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public int getSeats() {
        return seats;
    }

    public AddRestaurantServiceModel setSeats(int seats) {
        this.seats = seats;
        return this;
    }
}
