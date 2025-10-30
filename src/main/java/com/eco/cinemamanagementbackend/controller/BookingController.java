//package com.eco.cinemamanagementbackend.controller;
//
//
//import com.eco.cinemamanagementbackend.dto.common.ApiResponse;
//import com.eco.cinemamanagementbackend.dto.request.booking.CreateBookingRequest;
//import com.eco.cinemamanagementbackend.dto.response.booking.BookingResponse;
//import com.eco.cinemamanagementbackend.entity.Customer;
//import com.eco.cinemamanagementbackend.service.BookingService;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/bookings")
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@RequiredArgsConstructor
//@Slf4j
//public class BookingController {
//
//    final BookingService bookingService;
//    @PostMapping
//    public ApiResponse<BookingResponse> creatBooking(@RequestBody CreateBookingRequest request, Authentication authentication) {
//        Customer customer = (Customer) authentication.getPrincipal();
//        BookingResponse response = bookingService.creatBooking(request, customer);
//        return ApiResponse.success(response, "Tao thanh cong");
//}
//    @GetMapping("/{id}")
//    public ApiResponse<BookingResponse> getBookingById(@PathVariable Integer id) {
//        BookingResponse respone = bookingService.getBookingsById(id);
//        return ApiResponse.success(respone);
//    }
//
//    @GetMapping("/customer")
//    public ApiResponse<BookingResponse> getBookingByCustomer(@RequestBody Customer customer) {
//        BookingResponse response = bookingService.getAllBookingsByCustomer(customer);
//
//    }
//
//}
