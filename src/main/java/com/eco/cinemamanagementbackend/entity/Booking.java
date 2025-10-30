package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
//Nhiều booking với 1 customer
    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    Showtime showtime;
//nhiều booking với 1 suất chiếu
    @Column(nullable = false, unique = true)
    String bookingCode;
// mã đặt không được để trống
    @Column(nullable = false)
    Integer totalSeats;
// số lượng ghế đặt
    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal totalAmount;
// tổng lượng tiền
    @Column(precision = 10, scale = 2)
    BigDecimal discountAmount = BigDecimal.ZERO;
// tiền giảm giá mặc định là 0
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
// ngày đặt tự động thêm
    LocalDateTime paymentDate;
// ngày thanh toán
    LocalDateTime cancellationDate;
// ngày hủy bỏ đặt
    String notes;
//ghi chú
    public enum PaymentMethod {
        CASH, CREDIT_CARD, DEBIT_CARD, MOMO, ZALOPAY, VNPAY, BANK_TRANSFER
    }
// định nghĩa enum payment phương thức
    public enum PaymentStatus {
        PENDING, PAID, FAILED, REFUNDED
    }
// định nghĩa enum trạng thái thanh toán đặt mặc ssinhj là chờ
    public enum BookingStatus {
        CONFIRMED, CANCELLED, COMPLETED
    }// định nghĩa enum trạng thái đặt mặc định là xác nhận

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    List<BookingConcession> bookingConcessions= new ArrayList<>();

    @UpdateTimestamp
    LocalDateTime updatedAt;
}

