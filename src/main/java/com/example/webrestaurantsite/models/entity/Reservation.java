package com.example.webrestaurantsite.models.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation extends BasicEntity {
    private LocalDateTime dateTime;
    private User user;
    private Restaurant restaurant;

    public Reservation() {
    }

    @FutureOrPresent
    @NotNull
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Reservation setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Reservation setUser(User user) {
        this.user = user;
        return this;
    }

    @ManyToOne
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Reservation setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
