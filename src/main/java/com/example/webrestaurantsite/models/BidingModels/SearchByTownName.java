package com.example.webrestaurantsite.models.BidingModels;

import javax.validation.constraints.NotNull;

public class SearchByTownName {
    private String city;

    @NotNull
    public String getCity() {
        return city;
    }

    public SearchByTownName setCity(String city) {
        this.city = city;
        return this;
    }
}
