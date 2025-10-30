package com.eco.cinemamanagementbackend.repository;

import com.eco.cinemamanagementbackend.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {
}
