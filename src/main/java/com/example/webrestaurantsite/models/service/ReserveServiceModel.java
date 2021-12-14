package com.example.webrestaurantsite.models.service;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

public class ReserveServiceModel {
    LocalDateTime dateTime;


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public ReserveServiceModel setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
