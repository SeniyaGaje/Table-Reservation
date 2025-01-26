package com.example.Table_Reservation.dto.response;

import lombok.Data;

@Data
public class ReservationResponseDTO {
    private Long id;
    private String reservationTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String reservedTableNumbers;
    private String status;
}
