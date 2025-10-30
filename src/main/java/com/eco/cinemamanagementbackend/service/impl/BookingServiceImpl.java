package com.eco.cinemamanagementbackend.service.impl;

import com.eco.cinemamanagementbackend.dto.request.booking.CreateBookingRequest;
import com.eco.cinemamanagementbackend.dto.request.booking.UpdateBookingRequest;
import com.eco.cinemamanagementbackend.dto.response.booking.BookingResponse;
import com.eco.cinemamanagementbackend.entity.Booking;
import com.eco.cinemamanagementbackend.entity.Customer;
import com.eco.cinemamanagementbackend.repository.BookingRepository;
import com.eco.cinemamanagementbackend.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {


    @Override
    public BookingResponse creatBooking(CreateBookingRequest request, Customer customer) {
        return null;
    }

    @Override
    public BookingResponse updateBooking(Booking booking, Customer customer) {
        return null;
    }

    @Override
    public List<BookingResponse> getAllBookingsByCustomer(Customer customer) {
        return List.of();
    }

    @Override
    public BookingResponse updateBooking(Integer id, UpdateBookingRequest request) {
        return null;
    }

    @Override
    public void deleteBooking(Integer id) {

    }

    @Override
    public void cancelBooking(Integer id) {

    }
}
