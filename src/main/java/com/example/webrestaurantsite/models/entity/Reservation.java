package com.example.webrestaurantsite.models.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reservations")
public class Reservation extends BasicEntity {
    private LocalDate dateTime;
    private User user;
    private Restaurant restaurant;
    private int peopleCount;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public Reservation setUser(User user) {
        this.user = user;
        return this;
    }

    @Positive
    public int getPeopleCount() {
        return peopleCount;
    }

    public Reservation setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
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
    @JoinColumn(name = "restaurant_id")
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Reservation setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
