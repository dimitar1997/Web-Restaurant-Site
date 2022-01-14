package com.example.webrestaurantsite.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends BasicEntity {

    private String name;
    private String description;
    private String address;
    private User owner;
    private int capacity;
    private int leftCapacity;
    private Town city;

    private List<Reservation> reservations;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "restaurant")
    public List<Reservation> getReservations() {
        return reservations;
    }

    public Restaurant setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
        return this;
    }

    public int getLeftCapacity() {
        return leftCapacity;
    }

    public Restaurant setLeftCapacity(int leftCapacity) {
        this.leftCapacity = leftCapacity;
        return this;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    public Town getCity() {
        return city;
    }

    public Restaurant setCity(Town city) {
        this.city = city;
        return this;
    }

    @NotNull
    public int getCapacity() {
        return capacity;
    }

    public Restaurant setCapacity(int capacity) {
        this.capacity = capacity;
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

    @ManyToOne(fetch = FetchType.EAGER)
    public User getOwner() {
        return owner;
    }

    public Restaurant setOwner(User user) {
        this.owner = user;
        return this;
    }
}
