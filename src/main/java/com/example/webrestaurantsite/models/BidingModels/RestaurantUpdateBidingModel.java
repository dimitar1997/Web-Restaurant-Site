package com.example.webrestaurantsite.models.BidingModels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class RestaurantUpdateBidingModel {
    private Long id;
    private String name;
    private String description;
    private String address;
    private int capacity;

    public Long getId() {
        return id;
    }

    public RestaurantUpdateBidingModel setId(Long id) {
        this.id = id;
        return this;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public RestaurantUpdateBidingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 10)
    public String getDescription() {
        return description;
    }

    public RestaurantUpdateBidingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull
    public String getAddress() {
        return address;
    }

    public RestaurantUpdateBidingModel setAddress(String address) {
        this.address = address;
        return this;
    }

    @Positive
    public int getCapacity() {
        return capacity;
    }

    public RestaurantUpdateBidingModel setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }
}
