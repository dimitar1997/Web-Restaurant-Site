package com.example.webrestaurantsite.models.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "towns")
public class Town extends BasicEntity {
    private String name;
    private List<Restaurant> restaurants;


    public Town() {
    }

    @OneToMany(mappedBy = "town", fetch = FetchType.EAGER)
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Town setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
        return this;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }

}
