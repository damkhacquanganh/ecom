package com.eco.cinemamanagementbackend.repository;

import com.eco.cinemamanagementbackend.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
