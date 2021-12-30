package com.example.webrestaurantsite.models.service;



public class AddRestaurantServiceModel {
    private String name;
    private String description;
    private String address;
    private int capacity;
    private String city;


    public String getCity() {
        return city;
    }

    public AddRestaurantServiceModel setCity(String city) {
        this.city = city;
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


    public int getCapacity() {
        return capacity;
    }

    public AddRestaurantServiceModel setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }
}
