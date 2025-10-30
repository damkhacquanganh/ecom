package com.eco.cinemamanagementbackend.repository;

import com.eco.cinemamanagementbackend.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionReponsitory extends JpaRepository<Promotion, Integer> {
}
