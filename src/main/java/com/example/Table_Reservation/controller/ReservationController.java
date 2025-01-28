package com.example.Table_Reservation.controller;

import com.example.Table_Reservation.dto.request.ReservationRequestDTO;
import com.example.Table_Reservation.dto.response.ReservationResponseDTO;
import com.example.Table_Reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Create Reservation
    @PostMapping
    public ResponseEntity<?> createReservation(@Valid @RequestBody ReservationRequestDTO requestDTO) {
        try {
            ReservationResponseDTO responseDTO = reservationService.createReservation(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // Get Reservation by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable Long id) {
        try {
            ReservationResponseDTO responseDTO = reservationService.getReservationById(id);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // Get All Reservations
    @GetMapping
    public ResponseEntity<?> getAllReservations() {
        try {
            List<ReservationResponseDTO> reservations = reservationService.getAllReservations();
            return ResponseEntity.ok(reservations);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // Update Reservation
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @Valid @RequestBody ReservationRequestDTO requestDTO) {
        try {
            ReservationResponseDTO responseDTO = reservationService.updateReservation(id, requestDTO);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // Delete Reservation
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id) {
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // Filter Reservations by Date and Status
    @GetMapping("/filter")
    public ResponseEntity<?> filterReservations(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("status") Integer status) {
        try {
            List<ReservationResponseDTO> reservations = reservationService.filterReservations(startDate, endDate, status);
            return ResponseEntity.ok(reservations);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
