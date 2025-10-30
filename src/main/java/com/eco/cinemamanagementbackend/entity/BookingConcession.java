package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "booking_concessions")//bảng phụ nhiều nhiều
public class BookingConcession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer bookingConcessionId;
// id booking đặt đơn hàng
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    Booking booking;
// nhiều đơn đặt với một lần booking
    @ManyToOne
    @JoinColumn(name = "concession_id", nullable = false)
    Concession concession;

    @Column(nullable = false)
    Integer quantity = 1;
// số lượng đặt
    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal unitPrice;
// đơn vị giá
    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal totalPrice;
// tổng giá tiền
    @CreationTimestamp
    LocalDateTime createdAt;
}// thời gian được tạo
