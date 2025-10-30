package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "employees")
public class Employee extends User {
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    Cinema cinema;

    LocalDate hireDate;

    @Column(precision = 10, scale = 2)
    BigDecimal salary;

    boolean isActive = true;
}