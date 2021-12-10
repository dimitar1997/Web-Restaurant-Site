package com.example.webrestaurantsite.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "towns")
public class Town extends BasicEntity {
    private String name;
    private List<Restaurant> restaurants;

    public Town() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }

    @OneToMany
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Town setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
        return this;
    }
}
