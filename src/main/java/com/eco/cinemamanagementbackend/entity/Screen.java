package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "screens")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer screenId;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    @Column(nullable = false)
    private String screenName;

    @Enumerated(EnumType.STRING)
    private ScreenType screenType = ScreenType.STANDARD;

    @Column(nullable = false)
    private Integer totalSeats;

    @Column(columnDefinition = "JSON")
    private String seatLayout;

    @Column(precision = 5, scale = 2)
    private BigDecimal screenWidth;

    @Column(precision = 5, scale = 2)
    private BigDecimal screenHeight;

    private String soundSystem;
    private String projectorType;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public enum ScreenType {
        STANDARD, _3D, IMAX, _4DX, VIP, PREMIUM  // Note: 3D và 4DX dùng _ để tránh số
    }

    public enum Status {
        ACTIVE, INACTIVE, MAINTENANCE
    }
}
