package com.example.webrestaurantsite.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends BasicEntity {

    private String name;
    private String description;
    private String address;
    private User owner;
    private int seats;
    private Town town;

    @ManyToOne
    @NotNull
    public Town getTown() {
        return town;
    }

    public Restaurant setTown(Town town) {
        this.town = town;
        return this;
    }

    @NotNull
    public int getSeats() {
        return seats;
    }

    public Restaurant setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Restaurant setName(String name) {
        this.name = name;
        return this;
    }


    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Restaurant setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column
    public String getAddress() {
        return address;
    }

    public Restaurant setAddress(String address) {
        this.address = address;
        return this;
    }

    @ManyToOne
    public User getOwner() {
        return owner;
    }

    public Restaurant setOwner(User user) {
        this.owner = user;
        return this;
    }
}
