package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType = TicketType.ADULT;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    private String qrCode;
    private Boolean isUsed = false;
    private LocalDateTime usedAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public enum TicketType {
        ADULT, CHILD, STUDENT, SENIOR
    }
}
