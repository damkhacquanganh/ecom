package com.eco.cinemamanagementbackend.dto.response.booking;


import com.eco.cinemamanagementbackend.entity.Booking;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {
    Integer bookingId;
    Integer customerId;
    Integer showtimeId;
    String bookingCode;
    Integer totalSeats;
    BigDecimal totalAmount;
    BigDecimal discountAmount;
    BigDecimal finalAmount;
    String paymentMethod;
    String paymentStatus;
    String bookingStatus;
    LocalDate bookingDate;
    LocalTime paymentDate;
    LocalDateTime cancellationDate;
    LocalDateTime updatedAt;
    String notes;
}
