package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @Column(nullable = false, length = 5)
    private String seatRow;

    @Column(nullable = false)
    private Integer seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType = SeatType.STANDARD;

    private Integer positionX;
    private Integer positionY;
    private Boolean isAvailable = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public enum SeatType {
        STANDARD, VIP, COUPLE, WHEELCHAIR
    }
}
