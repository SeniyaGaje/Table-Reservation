package com.example.Table_Reservation.service;

import com.example.Table_Reservation.dto.request.ReservationRequestDTO;
import com.example.Table_Reservation.dto.response.ReservationResponseDTO;

import java.util.List;

public interface ReservationService {
    ReservationResponseDTO createReservation(ReservationRequestDTO requestDTO);
    List<ReservationResponseDTO> getAllReservations();
    ReservationResponseDTO getReservationById(Long id);
    ReservationResponseDTO updateReservation(Long id, ReservationRequestDTO requestDTO);
    void deleteReservation(Long id);
}
