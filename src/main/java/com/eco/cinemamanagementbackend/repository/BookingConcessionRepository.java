package com.eco.cinemamanagementbackend.repository;


import com.eco.cinemamanagementbackend.entity.BookingConcession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingConcessionRepository extends JpaRepository<BookingConcession, Integer> {
}
