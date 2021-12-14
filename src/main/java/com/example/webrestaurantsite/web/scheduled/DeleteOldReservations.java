package com.example.webrestaurantsite.web.scheduled;

import com.example.webrestaurantsite.repository.ReservationRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DeleteOldReservations {
    private final ReservationRepository reservationRepository;

    public DeleteOldReservations(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteOldReservation() {
        LocalDateTime localDateTime = LocalDateTime.now();
        reservationRepository.deleteByDateTimeLessThan(localDateTime);
    }
}
