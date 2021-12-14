package com.example.webrestaurantsite.models.BidingModels;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

public class ReserveBidingModel {
    LocalDateTime dateTime;

    @FutureOrPresent
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public ReserveBidingModel setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
