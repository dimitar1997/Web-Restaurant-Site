package com.example.webrestaurantsite.models.BidingModels;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;


public class ReserveBidingModel {
    private Long restaurantId;
    private LocalDate dateTime;
    private int peopleCount;

    @Positive
    public int getPeopleCount() {
        return peopleCount;
    }

    @NotNull
    public Long getRestaurantId() {
        return restaurantId;
    }

    public ReserveBidingModel setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

    public ReserveBidingModel setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
        return this;
    }

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDateTime() {
        return dateTime;
    }

    public ReserveBidingModel setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
