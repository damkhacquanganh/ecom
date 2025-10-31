package com.eco.cinemamanagementbackend.service;

import com.eco.cinemamanagementbackend.dto.request.customer.CreateCustomerRequest;
import com.eco.cinemamanagementbackend.dto.request.customer.UpdateCustomerRequest;
import com.eco.cinemamanagementbackend.dto.response.customer.CustomerResponse;
import com.eco.cinemamanagementbackend.entity.Customer;
import com.eco.cinemamanagementbackend.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface CustomerService {
    CustomerResponse createCustomer(CreateCustomerRequest request);

    CustomerResponse getCustomerById(Integer id);

    List<CustomerResponse> getAllCustomers();

    CustomerResponse updateCustomer(Integer id, UpdateCustomerRequest request);

    void deleteCustomer(Integer id);

}
