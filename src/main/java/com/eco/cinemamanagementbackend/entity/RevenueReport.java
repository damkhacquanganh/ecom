package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "revenue_reports")
public class RevenueReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @Column(nullable = false)
    private LocalDate reportDate;

    private Integer totalBookings = 0;
    private Integer totalTicketsSold = 0;

    @Column(precision = 10, scale = 2)
    private BigDecimal ticketRevenue = BigDecimal.ZERO;

    @Column(precision = 10, scale = 2)
    private BigDecimal concessionRevenue = BigDecimal.ZERO;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalRevenue = BigDecimal.ZERO;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalDiscount = BigDecimal.ZERO;

    @Column(precision = 10, scale = 2)
    private BigDecimal netRevenue = BigDecimal.ZERO;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
