package com.eco.cinemamanagementbackend.repository;

import com.eco.cinemamanagementbackend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByCustomerId(Integer customerId);
// lấy list booking thông qua customerid
    @Query("SELECT b from Booking b where b.bookingDate >= :startDate and b.bookingDate <= :endDate")
    List<Booking> findByBookingDateBetween(@Param("startDate") LocalDateTime startDate,@Param("endDate") LocalDateTime endDate);
// lấy list booking giữa hai thời gian

    Optional<Booking> findByBookingId(Integer bookingId);
}
