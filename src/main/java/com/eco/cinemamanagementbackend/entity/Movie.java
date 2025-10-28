package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer movieId;
// thêm mã phim được tự động sinh
    @Column(nullable = false)
    String title;
// tiêu đề không được để trống
    String originalTitle;
    //Tiêu đề gốc
    String description;
//Mô tả
    @Column(nullable = false)
    Integer duration;
// khoảng thời gian phim dự kiến
    LocalDate releaseDate;
    //thời gian phát hành
    LocalDate endDate;
    // thời gian kết thúc
    String director;
    //tác giả
    String cast;
    // diễn viên
    String country;
    //nước
    String language;
// ngôn ngữ
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    AgeRating ageRating;
// độ tuổi được định nghĩa
    String posterUrl;
    //link poster qua cloundinary
    String trailerUrl;
//link trailer qua cloundinary
    @Column(precision = 3, scale = 1)
    BigDecimal imdbRating;
// đánh giá imdb
    @Enumerated(EnumType.STRING)
    MovieFormat movieFormat = MovieFormat._2D;
// định dạng movie đuược định nghĩa trong enum và được mặc định là 2D;
    @Enumerated(EnumType.STRING)
    Status status = Status.COMING_SOON;
// trạng thái được định nghĩa trong định nghĩa và được mặc định là sắp đến
    @CreationTimestamp
    LocalDateTime createdAt;
// thời gian được tạo tự động của phần tạo lần đầu
    @UpdateTimestamp
    LocalDateTime updatedAt;
// thời gian cập nhật được tự động cập nhật
    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    Set<Genre> genres = new HashSet<>();
// thể loại được set theo tạo thêm nhằm tối ưu truy vấn tìm kiếm thể loại
    public enum AgeRating {
        P, K, T13, T16, T18, C
    }
// định nghĩa độ tuổi được xem
    public enum MovieFormat {
        _2D, _3D, IMAX, _4DX
    }
// định nghĩa dạng phim
    public enum Status {
        COMING_SOON, NOW_SHOWING, ENDED
    }
}// định nghĩa trạng tháo của status
