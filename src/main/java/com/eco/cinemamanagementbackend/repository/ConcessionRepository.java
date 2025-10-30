package com.eco.cinemamanagementbackend.repository;

import com.eco.cinemamanagementbackend.entity.Concession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessionRepository extends JpaRepository<Concession, Integer> {
}
