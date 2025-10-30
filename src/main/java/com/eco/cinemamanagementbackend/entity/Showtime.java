package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "showtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer showtimeId;
// id suất chiếu ia được thêm tự đông sinh mã
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    Movie movie;
// 1 suất chiếu có nhiều phim và không được để trống
    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    Screen screen;
// 1 suất chiếu có màn hình và không được để trống
    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    Cinema cinema;
// một suất chiếu cho nhiều rạp và không được để trống
    @Column(nullable = false)
    LocalDate showDate;
//ngày chiếu không được để trống
    @Column(nullable = false)
    LocalTime startTime;
// giờ bắt đầu không được để trống
    @Column(nullable = false)
    LocalTime endTime;
// giờ kết thúc không được để trống
    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal basePrice;
// giá cơ bản không được để trống
    @Enumerated(EnumType.STRING)
    Status status = Status.SCHEDULED;
//trạng thái được định nghĩa
    Integer availableSeats;
//ghế còn trống
    @CreationTimestamp
    LocalDateTime createdAt;
//thời gian tạo lần đầu được thêm tự động
    @UpdateTimestamp
    LocalDateTime updatedAt;
// thời gian cập nhật được thêm tự động
    public enum Status {
        SCHEDULED, ONGOING, COMPLETED, CANCELLED
    }// định nghĩa trạng thái mặc ssinhj là scheduled
}
