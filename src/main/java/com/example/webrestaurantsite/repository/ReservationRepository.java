package com.example.webrestaurantsite.repository;

import com.example.webrestaurantsite.models.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUserUsername(String username);
    void deleteByDateTimeLessThan(LocalDateTime dateTime);
}
