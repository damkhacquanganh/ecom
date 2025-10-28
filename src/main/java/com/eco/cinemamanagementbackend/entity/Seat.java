package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer seatId;
// mã ghế
    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    Screen screen;
//nhiều ghết với 1phongf không được để trống
    @Column(nullable = false, length = 5)
    String seatRow;
// hàng ghế không được để trống
    @Column(nullable = false)
    Integer seatNumber;
// số thứ tự trong hàng
    @Enumerated(EnumType.STRING)
    SeatType seatType = SeatType.STANDARD;
// loại nghế được định nghĩa
    Integer positionX;
    //trục x
    Integer positionY;
    //trục Y
    Boolean isAvailable = true;
// khả dụng mặc định là đúng
    @CreationTimestamp
    LocalDateTime createdAt;
// thời gian được tạo tự động khi khởi tọa
    public enum SeatType {
        STANDARD, VIP, COUPLE, WHEELCHAIR
    }//định nghĩa loại ghế
}
