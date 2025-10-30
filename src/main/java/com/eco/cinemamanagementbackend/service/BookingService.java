package com.eco.cinemamanagementbackend.service;

import com.eco.cinemamanagementbackend.dto.request.booking.CreateBookingRequest;
import com.eco.cinemamanagementbackend.dto.request.booking.UpdateBookingRequest;
import com.eco.cinemamanagementbackend.dto.response.booking.BookingResponse;
import com.eco.cinemamanagementbackend.entity.Booking;
import com.eco.cinemamanagementbackend.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    BookingResponse creatBooking(CreateBookingRequest request, Customer customer);

    BookingResponse updateBooking(Booking booking, Customer customer);

    List<BookingResponse> getAllBookingsByCustomer(Customer customer);

    BookingResponse updateBooking(Integer id, UpdateBookingRequest request);

    void deleteBooking(Integer id);

    void cancelBooking(Integer id);

    BookingResponse getBookingsById(Integer id);
}
