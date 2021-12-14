package com.example.webrestaurantsite.service;

import com.example.webrestaurantsite.models.BidingModels.ReserveBidingModel;
import com.example.webrestaurantsite.models.entity.Reservation;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.service.impl.UserDetailsImpl;

import java.util.List;

public interface ReservationService {

    Reservation details(Long id);

    void makeReserve(Long restaurantId, UserDetailsImpl currentUser,ReserveBidingModel reserveBidingModel);

    List<Reservation> allCurrentUserReservations(UserDetailsImpl currentUser);
}
