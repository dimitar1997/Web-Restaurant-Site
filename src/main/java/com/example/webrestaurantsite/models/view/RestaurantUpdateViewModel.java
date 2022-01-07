package com.example.webrestaurantsite.models.view;

public class RestaurantUpdateViewModel {
    private Long id;
    private String name;
    private String description;
    private String address;
    private int capacity;

    public Long getId() {
        return id;
    }

    public RestaurantUpdateViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RestaurantUpdateViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RestaurantUpdateViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public RestaurantUpdateViewModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public RestaurantUpdateViewModel setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }
}
