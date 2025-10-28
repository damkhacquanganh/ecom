package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cinema_chains")
public class CinemaChain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer chainId;
//id hệ thống
    @Column(nullable = false)
    String chainName;
// tên hệ thống
    String headquartersAddress;
// địa chỉ
    String hotline;
// liên hệ
    String email;
// email
    String website;
//link website
    String logoUrl;
    // link logo liên kết qua cloundinary
    @CreationTimestamp
    LocalDateTime createdAt;
// tự động tạo thời gian khi tạo mới lần đâu
    @UpdateTimestamp
    LocalDateTime updatedAt;
}// tự động cập nhật thời gian qua lần đầu
