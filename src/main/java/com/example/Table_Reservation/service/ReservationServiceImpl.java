package com.example.Table_Reservation.service;

import com.example.Table_Reservation.dto.request.ReservationRequestDTO;
import com.example.Table_Reservation.dto.response.ReservationResponseDTO;
import com.example.Table_Reservation.entity.Reservation;
import com.example.Table_Reservation.exception.ReservationNotFoundException;
import com.example.Table_Reservation.repository.ReservationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ReservationResponseDTO createReservation(ReservationRequestDTO requestDTO) {
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(requestDTO, reservation);
        Reservation savedReservation = reservationRepository.save(reservation);
        return mapToResponseDTO(savedReservation);
    }

    @Override
    public ReservationResponseDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation with ID " + id + " not found"));
        return mapToResponseDTO(reservation);
    }

    @Override
    public List<ReservationResponseDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationResponseDTO updateReservation(Long id, ReservationRequestDTO requestDTO) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation with ID " + id + " not found"));
        BeanUtils.copyProperties(requestDTO, reservation);
        Reservation updatedReservation = reservationRepository.save(reservation);
        return mapToResponseDTO(updatedReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new ReservationNotFoundException("Reservation with ID " + id + " not found");
        }
        reservationRepository.deleteById(id);
    }

    @Override
    public List<ReservationResponseDTO> filterReservations(String startDate, String endDate, Integer status) {
        List<Reservation> reservations = reservationRepository.filterReservations(
                LocalDate.parse(startDate), LocalDate.parse(endDate), status);
        return reservations.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private ReservationResponseDTO mapToResponseDTO(Reservation reservation) {
        ReservationResponseDTO responseDTO = new ReservationResponseDTO();
        BeanUtils.copyProperties(reservation, responseDTO);
        return responseDTO;
    }
}
