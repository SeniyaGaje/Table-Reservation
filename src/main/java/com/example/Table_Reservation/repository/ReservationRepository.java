package com.example.Table_Reservation.repository;

import com.example.Table_Reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends
        JpaRepository<Reservation, Long> {
}
