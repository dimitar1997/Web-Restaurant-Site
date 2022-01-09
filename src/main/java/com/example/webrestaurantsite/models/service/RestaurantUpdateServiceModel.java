package com.example.webrestaurantsite.models.service;

public class RestaurantUpdateServiceModel {
    private Long id;
    private String name;
    private String description;
    private String address;
    private int capacity;

    public Long getId() {
        return id;
    }

    public RestaurantUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RestaurantUpdateServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RestaurantUpdateServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public RestaurantUpdateServiceModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public RestaurantUpdateServiceModel setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }
}
