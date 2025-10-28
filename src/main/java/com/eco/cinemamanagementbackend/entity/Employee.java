package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer employeeId;
// khai báo nhân viên id và tự sinh mã nhân viên
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    Cinema cinema;
//Nối một nhiều với bảng cinema
    @Column(nullable = false)
    String fullName;
// khai báo full name nhân viên và không được để trống
    @Column(nullable = false, unique = true)
    String email;
//email là duy nhất và không được đê trống
    String phone;
//số điện thoại
    @Column(nullable = false)
    String passwordHash;
// mã hash mật khẩu không được để trống
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Role role;
// khai báo role không được để trống và thuộc kiểu định nghĩa enum
    LocalDate hireDate;
//khai báo ngày thuê
    @Column(precision = 10, scale = 2)
    BigDecimal salary;
//lương
    Boolean isActive = true;
//được kích hoạt mặc định là có
    @CreationTimestamp
    LocalDateTime createdAt;
//thời gian tạo được cập nhật tự động
    @UpdateTimestamp
    LocalDateTime updatedAt;
// thời gian cập nhật
    public enum Role {
        ADMIN, MANAGER, CASHIER, USHER, TECHNICIAN
    }
}// định nghĩa enum Role
