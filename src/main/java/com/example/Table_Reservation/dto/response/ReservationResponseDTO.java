package com.example.Table_Reservation.dto.response;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservationResponseDTO {
    private Long id;
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
    private Integer status;
    private String remarks;
}
