package com.eco.cinemamanagementbackend.repository;

import com.eco.cinemamanagementbackend.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatReponsitory extends JpaRepository<Seat, Integer> {
}
