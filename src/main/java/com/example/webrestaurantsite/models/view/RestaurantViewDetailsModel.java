package com.example.webrestaurantsite.models.view;



public class RestaurantViewDetailsModel {
    private Long id;
    private String name;
    private String description;
    private String address;
    private int seats;

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

    public int getSeats() {
        return seats;
    }

    public RestaurantViewDetailsModel setSeats(int seats) {
        this.seats = seats;
        return this;
    }
}
