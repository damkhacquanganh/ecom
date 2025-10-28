package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer customerId;
//xác định id và tự động sinh mã
    @Column(nullable = false)
    String fullName;
// Fullname không được để trống
    @Column(unique = true)
    String email;
// Email và là cột duy nhất
    @Column(unique = true, nullable = false)
    String phone;
// phone không được để trống và duy nhất
    @Column(nullable = false)
    String passwordHash;
//mật khẩu mã hóa và không được để trống
    LocalDate dateOfBirth;
// sinh nhật
    @Enumerated(EnumType.STRING)
    Gender gender;
// giới tính được định nghĩa trong enum
    String avatarUrl;
    //link avatar qua url thông qua bên thứ 3 cloundinary
    Integer loyaltyPoints = 0;
// điểm trung thành tích lũy có thể đặt trên fe là điểm tích lũy cho thân thiện
    @Enumerated(EnumType.STRING)
    MembershipTier membershipTier = MembershipTier.BRONZE;
// định nghĩa xếp hạng khách hàng thân thuộc mặc định ban đầu là bronze
    Boolean isVerified = false;
    //xác nhận là không mặc định
    LocalDateTime lastLogin;
// lần cuối đăng nhập
    @CreationTimestamp
    LocalDateTime createdAt;
//tạo thời gian tự động khi tạo lần đầu
    @UpdateTimestamp
    LocalDateTime updatedAt;
// cập nhật thời gian khi cập nhật
    public enum Gender {
        MALE, FEMALE, OTHER
    }
// định nhgiax enum giới tính
    public enum MembershipTier {
        BRONZE, SILVER, GOLD, PLATINUM
    }
}// định nghĩa enum cấp
