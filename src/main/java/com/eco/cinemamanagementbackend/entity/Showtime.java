package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "showtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer showtimeId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    Screen screen;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    Cinema cinema;

    @Column(nullable = false)
    LocalDate showDate;

    @Column(nullable = false)
    LocalTime startTime;

    @Column(nullable = false)
    LocalTime endTime;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal basePrice;

    @Enumerated(EnumType.STRING)
    Status status = Status.SCHEDULED;

    Integer availableSeats;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    public enum Status {
        SCHEDULED, ONGOING, COMPLETED, CANCELLED
    }
}
