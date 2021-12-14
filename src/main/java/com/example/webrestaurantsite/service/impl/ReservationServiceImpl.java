package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.BidingModels.ReserveBidingModel;
import com.example.webrestaurantsite.models.entity.Reservation;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.service.ReserveServiceModel;
import com.example.webrestaurantsite.repository.ReservationRepository;
import com.example.webrestaurantsite.repository.RestaurantRepository;
import com.example.webrestaurantsite.repository.UserRepository;
import com.example.webrestaurantsite.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ModelMapper modelMapper, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Reservation details(Long id) {
        return reservationRepository.getById(id);
    }

    @Override
    public void makeReserve(Long restaurantId, UserDetailsImpl currentUser, ReserveBidingModel reserveBidingModel) {
        ReserveServiceModel reserveServiceModel = modelMapper.map(reserveBidingModel, ReserveServiceModel.class);
        Reservation reservation = new Reservation();
        reservation.setDateTime(reserveServiceModel.getDateTime());
        reservation.setRestaurant(restaurantRepository.getById(restaurantId));
        reservation.setUser(userRepository.findByUsername(currentUser.getUserIdentifier()));
        reservationRepository.save(reservation);

    }

    @Override
    public List<Reservation> allCurrentUserReservations(UserDetailsImpl currentUser) {

        return reservationRepository.findAllByUserUsername(currentUser.getUserIdentifier());
    }
}
