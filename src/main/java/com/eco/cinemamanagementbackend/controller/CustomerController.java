package com.eco.cinemamanagementbackend.controller;

import com.eco.cinemamanagementbackend.dto.common.ApiResponse;
import com.eco.cinemamanagementbackend.dto.request.customer.CreateCustomerRequest;
import com.eco.cinemamanagementbackend.dto.request.customer.UpdateCustomerRequest;
import com.eco.cinemamanagementbackend.dto.response.customer.CustomerResponse;
import com.eco.cinemamanagementbackend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ApiResponse<CustomerResponse> creatCustomer(@RequestBody CreateCustomerRequest request) {
        CustomerResponse respone = customerService.createCustomer(request);
        return ApiResponse.success(respone, "Customer created");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN' or hasRole('CUSTOMER'))")
    public ApiResponse<CustomerResponse> getCustomerbyId(@PathVariable Integer id) {
        CustomerResponse respone = customerService.getCustomerById(id);
        return ApiResponse.success(respone);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")  // Chỉ admin xem all
    public ApiResponse<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> responses =  customerService.getAllCustomers();
        return ApiResponse.success(responses);
    }
    @PreAuthorize("hasRole('ADMIN' or hasRole('CUSTOMER'))")
    @PutMapping("/{id}")
    public ApiResponse<CustomerResponse> updateCustomer(@PathVariable Integer id, @RequestBody UpdateCustomerRequest request) {
        CustomerResponse respone = customerService.updateCustomer(id, request);
        return ApiResponse.success(respone, "Customer updated");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ApiResponse.success(null, "Customer deleted");
    }

}
