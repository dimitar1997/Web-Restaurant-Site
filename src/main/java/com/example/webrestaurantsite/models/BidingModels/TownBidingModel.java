package com.example.webrestaurantsite.models.BidingModels;

import javax.validation.constraints.NotNull;

public class TownBidingModel {
    private String city;

    @NotNull
    public String getCity() {
        return city;
    }

    public TownBidingModel setCity(String city) {
        this.city = city;
        return this;
    }
}
