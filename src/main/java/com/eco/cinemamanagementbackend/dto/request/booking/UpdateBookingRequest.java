package com.eco.cinemamanagementbackend.dto.request.booking;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBookingRequest {
    String paymentMethod;
    String notes;

}
