package com.eco.cinemamanagementbackend.repository;

import com.eco.cinemamanagementbackend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewReponsitory extends JpaRepository<Review, Integer> {
}
