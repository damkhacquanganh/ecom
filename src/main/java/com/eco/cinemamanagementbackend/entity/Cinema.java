package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cinemas")
public class Cinema {
    //rạp
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cinemaId;
// hệ thống
    @ManyToOne
    @JoinColumn(name = "chain_id")
    CinemaChain chain;
// tên rạp
    @Column(nullable = false)
    String cinemaName;
// địa chỉ
    @Column(nullable = false)
    String address;
// thành phố
    @Column(nullable = false)
    String city;
// quận huyện
    String district;
//số dt
    String phone;
//vĩ độ
    @Column(precision = 10, scale = 8)
    BigDecimal latitude;
// kinh độ
    @Column(precision = 11, scale = 8)
    BigDecimal longitude;
// tổng màn hình mặc định là 0
    Integer totalScreens = 0;
    Boolean parkingAvailable = false;
// tiện nghi lọc rạp theo json theo loại công nghệ vd 3D, MAX
    @Column(columnDefinition = "JSON")
    String facilities;  // Lưu dưới dạng String, parse JSON khi cần
// Trạng thái mặc định là hoạt động
    @Enumerated(EnumType.STRING)
    Status status = Status.ACTIVE;
// tạo thời gian đúng thời điểm theo anotation @CreationTimestamp của jpa
    @CreationTimestamp
    LocalDateTime createdAt;
// tạo thời gian cập nhật đúng líc theo anotation @UpdateTimestamp của jpa
    @UpdateTimestamp
    LocalDateTime updatedAt;
// khai báo enum biến của trạng thái nhằm không cho phép ngoài các trạng thái này
    public enum Status {
        ACTIVE, INACTIVE, MAINTENANCE
    }// hoạt động, không hoạt động, bảo trì
}
