package com.example.webrestaurantsite.models.service;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class SeedCitiesServiceModel {
    @Expose
    private String city;


    public String getCity() {
        return city;
    }

    public SeedCitiesServiceModel setCity(String city) {
        this.city = city;
        return this;
    }
}
