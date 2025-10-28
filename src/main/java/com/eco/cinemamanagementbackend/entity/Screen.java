package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "screens")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer screenId;
//mã màn hình được sinh tự động
    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    Cinema cinema;
// nối nhiều với một và không được để trống nhiều màn hình với 1 rạp chiếu
    @Column(nullable = false)
    String screenName;
//tên màn hình không được để trống
    @Enumerated(EnumType.STRING)
    ScreenType screenType = ScreenType.STANDARD;
//loại màn hình được định nghĩa trong enum là bình thường
    @Column(nullable = false)
    Integer totalSeats;
//tổng số ghế
    @Column(columnDefinition = "JSON")
    String seatLayout;
//sơ đồ ghế lưu bằng json
    @Column(precision = 5, scale = 2)
    BigDecimal screenWidth;
// chiều rộng màn hình
    @Column(precision = 5, scale = 2)
    BigDecimal screenHeight;
// chiều dài màn hình
    String soundSystem;
    //Hệ thống âm thanh
    String projectorType;
//máy chiếu loại
    @Enumerated(EnumType.STRING)
    Status status = Status.ACTIVE;
// trạng thái được định nghĩa trong enum là eactive
    @CreationTimestamp
    LocalDateTime createdAt;
//thời gian khởi tọa tự dộng khi tạo
    @UpdateTimestamp
    LocalDateTime updatedAt;
// thời gian cập nhật được khởi tạo tự động
    public enum ScreenType {
        STANDARD, _3D, IMAX, _4DX, VIP, PREMIUM  // Note: 3D và 4DX dùng _ để tránh số
    }
// định nghĩa loại màn hình
    public enum Status {
        ACTIVE, INACTIVE, MAINTENANCE
    }// định nghĩa trạng thái
}
