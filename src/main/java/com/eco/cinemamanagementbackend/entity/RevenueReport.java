package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "revenue_reports")
public class RevenueReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer reportId;
//id doanh thu báo cáo và được sinh tự động
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    Cinema cinema;
// nối nhiều một nhằm xác định rạp nào
    @Column(nullable = false)
    LocalDate reportDate;
//thời gian tạo báo cáo và không được để trống
    Integer totalBookings = 0;
    //khai báo tổng dược đặt vé là 0
    Integer totalTicketsSold = 0;
// khai báo tổng được tiket được bán ra là 0
    @Column(precision = 10, scale = 2)
    BigDecimal ticketRevenue = BigDecimal.ZERO;
// doanh thu vé được khai báo mặc định là 0
    @Column(precision = 10, scale = 2)
    BigDecimal concessionRevenue = BigDecimal.ZERO;
// doanh thu nhượng bộ mặc định là 0
    @Column(precision = 10, scale = 2)
    BigDecimal totalRevenue = BigDecimal.ZERO;
// tổng doanh thu được khai báo mặc định là 0
    @Column(precision = 10, scale = 2)
    BigDecimal totalDiscount = BigDecimal.ZERO;
// toongt giảm giá được khai báo mặc định là 0
    @Column(precision = 10, scale = 2)
    BigDecimal netRevenue = BigDecimal.ZERO;
// doanh thu ròng được mặc định là 0
    @CreationTimestamp
    LocalDateTime createdAt;
}// thời gian tạo báo cáo được tạo tự động
