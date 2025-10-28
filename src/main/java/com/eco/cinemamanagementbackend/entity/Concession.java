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
@Table(name = "concessions")
public class Concession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer concessionId;
// id món
    @Column(nullable = false)
    String itemName;
// tên món ăn
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Category category;
// cột không được để trống thể laoij và được định nghĩa enum trong category
    String description;
//Mô tả
    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal price;
// giá và không để trống
    String imageUrl;
// chuỗi url trả về từ cloundinary trả về ảnh món ăn
    Boolean isAvailable = true;
// mặc định khả năng là được
    @CreationTimestamp
    LocalDateTime createdAt;
// tự động tạo thời gian khi creatat lần đầu
    @UpdateTimestamp
    LocalDateTime updatedAt;
// tự động cập nhật thời gian khi update
    public enum Category {
        POPCORN, DRINK, SNACK, COMBO, OTHER
    }// định nghĩa enum Category
}
