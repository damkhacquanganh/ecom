package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cinemas")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaId;

    @ManyToOne
    @JoinColumn(name = "chain_id")
    private CinemaChain chain;

    @Column(nullable = false)
    private String cinemaName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    private String district;
    private String phone;

    @Column(precision = 10, scale = 8)
    private BigDecimal latitude;

    @Column(precision = 11, scale = 8)
    private BigDecimal longitude;

    private Integer totalScreens = 0;
    private Boolean parkingAvailable = false;

    @Column(columnDefinition = "JSON")
    private String facilities;  // Lưu dưới dạng String, parse JSON khi cần

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public enum Status {
        ACTIVE, INACTIVE, MAINTENANCE
    }
}
