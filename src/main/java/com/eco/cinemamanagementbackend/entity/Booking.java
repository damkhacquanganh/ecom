package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
// khai báo lombok
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//tự động sinh mã id
    Integer bookingId;
// nối nhiều một với cột customer
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    Showtime showtime;

    @Column(nullable = false, unique = true)
    String bookingCode;

    @Column(nullable = false)
    Integer totalSeats;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal totalAmount;

    @Column(precision = 10, scale = 2)
    BigDecimal discountAmount = BigDecimal.ZERO;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal finalAmount;
// Su dụng khai báo enum PaymentMethod ở dưới
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PaymentMethod paymentMethod;
// Khai báo dượi trên enum PaymentMethod ở dưới kèm trạng thái mặc định là pending đang chờ
    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus = PaymentStatus.PENDING;
// Khai báo dưới với enum BookingStatus ở dưới với trạng thái mặc định là confirmed xác nhận
    @Enumerated(EnumType.STRING)
    BookingStatus bookingStatus = BookingStatus.CONFIRMED;
// Anotation tự động gán thời gian bằng jpa khi đặt booking
    @CreationTimestamp
    LocalDateTime bookingDate;

    LocalDateTime paymentDate;

    LocalDateTime cancellationDate;

    String notes;

    public enum PaymentMethod {
        CASH, CREDIT_CARD, DEBIT_CARD, MOMO, ZALOPAY, VNPAY, BANK_TRANSFER
    }

    public enum PaymentStatus {
        PENDING, PAID, FAILED, REFUNDED
    }

    public enum BookingStatus {
        CONFIRMED, CANCELLED, COMPLETED
    }
}
