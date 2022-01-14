package com.example.webrestaurantsite.models.service;


import java.time.LocalDate;


public class ReserveServiceModel {
    private Long restaurantId;
    private LocalDate dateTime;
    private int people;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public ReserveServiceModel setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public ReserveServiceModel setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public int getPeople() {
        return people;
    }

    public ReserveServiceModel setPeople(int people) {
        this.people = people;
        return this;
    }
}
