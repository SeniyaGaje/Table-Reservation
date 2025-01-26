package com.example.Table_Reservation.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservationRequestDTO {
    private String reservationTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String emergencyMobile;
    private LocalDate date;
    private LocalTime reservationStartTime;
    private LocalTime reservationEndTime;
    private Integer numberOfPeople;
    private String reservedTableNumbers;
    private String status;
    private String remarks;
}
