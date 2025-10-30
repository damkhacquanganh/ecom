package com.eco.cinemamanagementbackend.repository;

import com.eco.cinemamanagementbackend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieReponsitory extends JpaRepository<Movie, Integer> {
}
