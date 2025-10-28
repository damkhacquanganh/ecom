package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(nullable = false)
    private String title;

    private String originalTitle;
    private String description;

    @Column(nullable = false)
    private Integer duration;

    private LocalDate releaseDate;
    private LocalDate endDate;
    private String director;
    private String cast;
    private String country;
    private String language;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AgeRating ageRating;

    private String posterUrl;
    private String trailerUrl;

    @Column(precision = 3, scale = 1)
    private BigDecimal imdbRating;

    @Enumerated(EnumType.STRING)
    private MovieFormat movieFormat = MovieFormat._2D;

    @Enumerated(EnumType.STRING)
    private Status status = Status.COMING_SOON;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    public enum AgeRating {
        P, K, T13, T16, T18, C
    }

    public enum MovieFormat {
        _2D, _3D, IMAX, _4DX
    }

    public enum Status {
        COMING_SOON, NOW_SHOWING, ENDED
    }
}
