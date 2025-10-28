package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer reviewId;
// mã nhận xét được tạo tự động
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    Movie movie;
// nối nhiều một với movie nhằm nhiều nhận xét
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;
    // nhiều nhận xét của 1 người
    @Column(nullable = false)
    Integer rating;
// điểm đánh giá
    String reviewText;
    //nhận xét viết
    Boolean isVerifiedViewer = false;
    //nhận xét xác nhận mặc định là tắt
    Integer helpfulCount = 0;
// điểm hữu ích mặc định là 0 kiểu người vote
    @CreationTimestamp
    LocalDateTime createdAt;
// thời gian tạo ra được tự động cập nhật
    @UpdateTimestamp
    LocalDateTime updatedAt;
}// thời gian được cập nhật
