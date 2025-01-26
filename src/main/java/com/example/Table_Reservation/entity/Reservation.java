package com.example.Table_Reservation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "reservations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"reservedTableNumbers", "date", "reservationStartTime", "reservationEndTime"}))

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Reservation title is required")
    private String reservationTitle;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number")
    @NotBlank(message = "Mobile number is required")
    private String mobile;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid emergency mobile number")
    @NotBlank(message = "Emergency mobile number is required")
    private String emergencyMobile;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Reservation start time is required")
    private LocalTime reservationStartTime;

    @NotNull(message = "Reservation end time is required")
    private LocalTime reservationEndTime;

    @Min(value = 1, message = "At least one person is required")
    private Integer numberOfPeople;

    @NotBlank(message = "Reserved table numbers are required")
    private String reservedTableNumbers;

    @NotNull(message = "Status is required")
    private Integer status;

    private String remarks;
}
