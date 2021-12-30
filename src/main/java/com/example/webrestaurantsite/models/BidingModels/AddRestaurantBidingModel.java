package com.example.webrestaurantsite.models.BidingModels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class AddRestaurantBidingModel {
    private String name;
    private String description;
    private String address;
    private int capacity;
    private String city;



    @NotNull
    public String getCity() {
        return city;
    }

    public AddRestaurantBidingModel setCity(String city) {
        this.city = city;
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
    @Size(min = 10)
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


    @Positive
    public int getCapacity() {
        return capacity;
    }

    public AddRestaurantBidingModel setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }
}
