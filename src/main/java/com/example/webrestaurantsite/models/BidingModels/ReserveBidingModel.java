package com.example.webrestaurantsite.models.BidingModels;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

public class ReserveBidingModel {
    LocalDateTime dateTime;

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
