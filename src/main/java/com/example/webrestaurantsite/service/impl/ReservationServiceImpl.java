package com.example.webrestaurantsite.service.impl;

import com.example.webrestaurantsite.models.BidingModels.ReserveBidingModel;
import com.example.webrestaurantsite.models.entity.Picture;
import com.example.webrestaurantsite.models.entity.Reservation;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.User;
import com.example.webrestaurantsite.models.service.ReserveServiceModel;
import com.example.webrestaurantsite.models.view.ListOfPeopleViewModel;
import com.example.webrestaurantsite.models.view.ReservationCustomViewModel;
import com.example.webrestaurantsite.models.view.ReservationViewDetailsModel;
import com.example.webrestaurantsite.repository.PictureRepository;
import com.example.webrestaurantsite.repository.ReservationRepository;
import com.example.webrestaurantsite.repository.RestaurantRepository;
import com.example.webrestaurantsite.repository.UserRepository;
import com.example.webrestaurantsite.service.ReservationService;
import com.example.webrestaurantsite.web.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;


    public ReservationServiceImpl(ReservationRepository reservationRepository, ModelMapper modelMapper, RestaurantRepository restaurantRepository, UserRepository userRepository, PictureRepository pictureRepository) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Reservation details(Long id) {
        return reservationRepository.getById(id);
    }

    @Override
    public void makeReserve(UserDetailsImpl currentUser, ReserveBidingModel reserveBidingModel) {
        ReserveServiceModel reserveServiceModel = modelMapper.map(reserveBidingModel, ReserveServiceModel.class);
        Reservation reservation = new Reservation();
        reservation.setDateTime(reserveServiceModel.getDateTime());
        reservation.setUser(userRepository.findByUsername(currentUser.getUserIdentifier()));
        Restaurant restaurant = restaurantRepository.findById(reserveBidingModel.getRestaurantId()).orElseThrow(() -> new ObjectNotFoundException("Restaurant not found"));
        reservation.setRestaurant(restaurant);
        reservation.setPeopleCount(reserveServiceModel.getPeople());
        restaurantRepository.save(restaurant);
        reservationRepository.save(reservation);

    }

    @Override
    public List<ReservationCustomViewModel> allCurrentUserReservations(UserDetailsImpl currentUser) {
        User user = userRepository.findByUsername(currentUser.getUsername());
        List<Reservation> reservations = reservationRepository.findAllByUserOrderByDateTimeAsc(user);
        List<ReservationCustomViewModel> rvdm = new LinkedList<>();
        for (Reservation r:reservations) {
            ReservationCustomViewModel rModel = new ReservationCustomViewModel();
            rModel.setId(r.getId());
            Picture picture = pictureRepository.findByRestaurantId(r.getRestaurant().getId());
            rModel.setName(r.getRestaurant().getName());
            rModel.setImgUrl(picture.getImageUrl());
            rvdm.add(rModel);
        }
        return rvdm;

    }

    @Override
    public ReservationViewDetailsModel findDetailReservation(Long reservationId) {
        ReservationViewDetailsModel rModel = new ReservationViewDetailsModel();
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new ObjectNotFoundException("Reservation whit " + reservationId + " not found!"));
        rModel.setDate(reservation.getDateTime().toString());
        rModel.setId(reservation.getId());
        rModel.setFirstName(reservation.getUser().getFirstName());
        rModel.setLastName(reservation.getUser().getLastName());
        rModel.setNameRestaurant(reservation.getRestaurant().getName());
        Picture picture = pictureRepository.findByRestaurantId(reservation.getRestaurant().getId());
        rModel.setImgUrl(picture.getImageUrl());
        rModel.setPeopleCount(reservation.getPeopleCount());
        return rModel;
    }

    @Override
    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new ObjectNotFoundException("Reservation whit " + reservationId + " not found!"));
        reservationRepository.delete(reservation);
    }

    @Override
    public boolean isFull(LocalDate dateTime, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new ObjectNotFoundException("Restaurant whit " + restaurantId + " not found!"));
        if (reservationRepository.findAllByDateTime(dateTime).size() >= restaurant.getCapacity()){
            return true;
        }
        return false;
    }

    @Override
    public List<ListOfPeopleViewModel> loadListOfPeople(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new ObjectNotFoundException("Restaurant whit " + restaurantId + " not found!"));
       List<Reservation> reservations = reservationRepository.findAllByRestaurant(restaurant);

       List<ListOfPeopleViewModel> listOfPeopleViewModels = new ArrayList<>();

        for (Reservation r: reservations) {
            ListOfPeopleViewModel listOfPeopleViewModel = new ListOfPeopleViewModel();
            listOfPeopleViewModel.setFullName(r.getUser().getFirstName() + " " + r.getUser().getLastName());
            listOfPeopleViewModel.setPeopleCount(r.getPeopleCount());
            listOfPeopleViewModels.add(listOfPeopleViewModel);
        }
        return listOfPeopleViewModels;
    }


}
