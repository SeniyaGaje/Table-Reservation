package com.example.Table_Reservation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "reservations")
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String status;
    private String remarks;
}
