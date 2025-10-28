package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer genreId;
// mã thể loại tự động sinh
    @Column(nullable = false, unique = true)
    String genreName;
// tên thể loại được đặc biệt và không được để trống
    String description;
// chuỗi mô tả
    @CreationTimestamp
    LocalDateTime createdAt;
    // thời gian được tạo được tạo
}
