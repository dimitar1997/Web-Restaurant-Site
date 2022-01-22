package com.example.webrestaurantsite.repository;

import com.example.webrestaurantsite.models.entity.Reservation;
import com.example.webrestaurantsite.models.entity.Restaurant;
import com.example.webrestaurantsite.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUserOrderByDateTimeAsc(User user);

    List<Reservation> findAllByDateTime(LocalDate dateTime);

    List<Reservation> findAllByRestaurant(Restaurant restaurant);

    void deleteByDateTimeLessThan(LocalDate dateTime);

    Optional<Reservation> findById(Long id);
}
