package com.example.webrestaurantsite.models.view;



public class RestaurantViewDetailsModel {
    private Long id;
    private String imgUrl;
    private String name;
    private String description;
    private String address;
    private int leftCapacity;
    private int capacity;
    private String city;

    public int getLeftCapacity() {
        return leftCapacity;
    }

    public RestaurantViewDetailsModel setLeftCapacity(int leftCapacity) {
        this.leftCapacity = leftCapacity;
        return this;
    }

    public String getCity() {
        return city;
    }

    public RestaurantViewDetailsModel setCity(String city) {
        this.city = city;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public RestaurantViewDetailsModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RestaurantViewDetailsModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RestaurantViewDetailsModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RestaurantViewDetailsModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public RestaurantViewDetailsModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public RestaurantViewDetailsModel setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }
}
