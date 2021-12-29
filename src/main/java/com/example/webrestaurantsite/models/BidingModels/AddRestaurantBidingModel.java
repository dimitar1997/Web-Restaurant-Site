package com.example.webrestaurantsite.models.BidingModels;

import com.example.webrestaurantsite.models.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddRestaurantBidingModel {
    private String name;
    private String description;
    private String address;
    private User owner;
    private int capacity;
    private String town;


    @NotNull
    public String getTown() {
        return town;
    }

    public AddRestaurantBidingModel setTown(String town) {
        this.town = town;
        return this;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public AddRestaurantBidingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddRestaurantBidingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull
    public String getAddress() {
        return address;
    }

    public AddRestaurantBidingModel setAddress(String address) {
        this.address = address;
        return this;
    }

    @NotNull
    public User getOwner() {
        return owner;
    }

    public AddRestaurantBidingModel setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    @Positive
    public int getCapacity() {
        return capacity;
    }

    public AddRestaurantBidingModel setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }
}
