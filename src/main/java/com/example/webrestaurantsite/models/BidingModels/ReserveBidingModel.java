package com.example.webrestaurantsite.models.BidingModels;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public class ReserveBidingModel {
    private Long restaurantId;
    private LocalDateTime dateTime;
    private int people;

    @Positive
    public int getPeople() {
        return people;
    }

    @NotNull
    public Long getRestaurantId() {
        return restaurantId;
    }

    public ReserveBidingModel setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

    public ReserveBidingModel setPeople(int people) {
        this.people = people;
        return this;
    }

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public ReserveBidingModel setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
