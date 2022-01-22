package com.example.webrestaurantsite.service;

import com.example.webrestaurantsite.models.BidingModels.ReserveBidingModel;
import com.example.webrestaurantsite.models.entity.Reservation;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.view.ListOfPeopleViewModel;
import com.example.webrestaurantsite.models.view.ReservationCustomViewModel;
import com.example.webrestaurantsite.models.view.ReservationViewDetailsModel;
import com.example.webrestaurantsite.service.impl.UserDetailsImpl;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    Reservation details(Long id);

    void makeReserve(UserDetailsImpl currentUser,ReserveBidingModel reserveBidingModel);

    List<ReservationCustomViewModel> allCurrentUserReservations(UserDetailsImpl currentUser);

    ReservationViewDetailsModel findDetailReservation(Long reservationId);

    void cancelReservation(Long reservationId);


    boolean isFull(LocalDate dateTime, Long restaurantId);

    List<ListOfPeopleViewModel> loadListOfPeople(Long restaurantId);
}
