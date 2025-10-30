package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tickets")//một booking có thể có nhiều vé
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ticketId;
// id vé đặt
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    Booking booking;
// nhiều vé cho 1 lần booking và không được để trống
    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    Seat seat;
//id ghế
    @Enumerated(EnumType.STRING)
    TicketType ticketType = TicketType.ADULT;
// loại vé được định nghĩa mặc định là người lớn
    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal price;
//giá không được để trống
    String qrCode;
    //chuỗi qr code
    Boolean isUsed = false;
    // giá trị sử dụng mặc định là không
    LocalDateTime usedAt;
    // thời gian sử dụng được định nghĩa

    @CreationTimestamp
    LocalDateTime createdAt;

    public enum TicketType {
        ADULT, CHILD, STUDENT, SENIOR
    }
}
