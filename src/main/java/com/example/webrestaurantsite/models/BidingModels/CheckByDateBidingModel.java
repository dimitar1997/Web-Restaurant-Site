package com.example.webrestaurantsite.models.BidingModels;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CheckByDateBidingModel {
    private LocalDate localDate;


    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getLocalDate() {
        return localDate;
    }

    public CheckByDateBidingModel setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
        return this;
    }
}
