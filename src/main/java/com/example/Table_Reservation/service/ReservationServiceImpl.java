package com.example.Table_Reservation.service.impl;

import com.example.Table_Reservation.dto.request.ReservationRequestDTO;
import com.example.Table_Reservation.dto.response.ReservationResponseDTO;
import com.example.Table_Reservation.entity.Reservation;
import com.example.Table_Reservation.repository.ReservationRepository;
import com.example.Table_Reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ReservationResponseDTO createReservation(ReservationRequestDTO requestDTO) {
        Reservation reservation = mapToEntity(requestDTO);
        Reservation savedReservation = reservationRepository.save(reservation);
        return mapToResponseDTO(savedReservation);
    }

    @Override
    public List<ReservationResponseDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationResponseDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        return mapToResponseDTO(reservation);
    }

    @Override
    public ReservationResponseDTO updateReservation(Long id, ReservationRequestDTO requestDTO) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        updateEntity(reservation, requestDTO);
        Reservation updatedReservation = reservationRepository.save(reservation);
        return mapToResponseDTO(updatedReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservationRepository.delete(reservation);
    }

    private Reservation mapToEntity(ReservationRequestDTO requestDTO) {
        Reservation reservation = new Reservation();
        reservation.setReservationTitle(requestDTO.getReservationTitle());
        reservation.setFirstName(requestDTO.getFirstName());
        reservation.setLastName(requestDTO.getLastName());
        reservation.setEmail(requestDTO.getEmail());
        reservation.setMobile(requestDTO.getMobile());
        reservation.setEmergencyMobile(requestDTO.getEmergencyMobile());
        reservation.setDate(requestDTO.getDate());
        reservation.setReservationStartTime(requestDTO.getReservationStartTime());
        reservation.setReservationEndTime(requestDTO.getReservationEndTime());
        reservation.setNumberOfPeople(requestDTO.getNumberOfPeople());
        reservation.setReservedTableNumbers(requestDTO.getReservedTableNumbers());
        reservation.setStatus(requestDTO.getStatus());
        reservation.setRemarks(requestDTO.getRemarks());
        return reservation;
    }

    private ReservationResponseDTO mapToResponseDTO(Reservation reservation) {
        ReservationResponseDTO responseDTO = new ReservationResponseDTO();
        responseDTO.setId(reservation.getId());
        responseDTO.setReservationTitle(reservation.getReservationTitle());
        responseDTO.setFirstName(reservation.getFirstName());
        responseDTO.setLastName(reservation.getLastName());
        responseDTO.setEmail(reservation.getEmail());
        responseDTO.setMobile(reservation.getMobile());
        responseDTO.setReservedTableNumbers(reservation.getReservedTableNumbers());
        responseDTO.setStatus(reservation.getStatus());
        return responseDTO;
    }

    private void updateEntity(Reservation reservation, ReservationRequestDTO requestDTO) {
        reservation.setReservationTitle(requestDTO.getReservationTitle());
        reservation.setFirstName(requestDTO.getFirstName());
        reservation.setLastName(requestDTO.getLastName());
        reservation.setEmail(requestDTO.getEmail());
        reservation.setMobile(requestDTO.getMobile());
        reservation.setEmergencyMobile(requestDTO.getEmergencyMobile());
        reservation.setDate(requestDTO.getDate());
        reservation.setReservationStartTime(requestDTO.getReservationStartTime());
        reservation.setReservationEndTime(requestDTO.getReservationEndTime());
        reservation.setNumberOfPeople(requestDTO.getNumberOfPeople());
        reservation.setReservedTableNumbers(requestDTO.getReservedTableNumbers());
        reservation.setStatus(requestDTO.getStatus());
        reservation.setRemarks(requestDTO.getRemarks());
    }
}
