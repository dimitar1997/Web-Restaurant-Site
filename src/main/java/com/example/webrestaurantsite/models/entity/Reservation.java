package com.example.webrestaurantsite.models.entity;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation extends BasicEntity {
    private LocalDate dateTime;
    private User user;
    private Restaurant restaurant;
    private int people;

    @Positive
    public int getPeople() {
        return people;
    }

    public Reservation setPeople(int people) {
        this.people = people;
        return this;
    }

    public Reservation() {
    }

    @FutureOrPresent
    @NotNull
    public LocalDate getDateTime() {
        return dateTime;
    }

    public Reservation setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    @ManyToOne()
    public User getUser() {
        return user;
    }

    public Reservation setUser(User user) {
        this.user = user;
        return this;
    }

    @ManyToOne()
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Reservation setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
