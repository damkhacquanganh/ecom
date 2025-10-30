package com.eco.cinemamanagementbackend.service.impl;

import com.eco.cinemamanagementbackend.dto.request.customer.CreateCustomerRequest;
import com.eco.cinemamanagementbackend.dto.request.customer.UpdateCustomerRequest;
import com.eco.cinemamanagementbackend.dto.response.customer.CustomerResponse;
import com.eco.cinemamanagementbackend.entity.Customer;
import com.eco.cinemamanagementbackend.entity.User;
import com.eco.cinemamanagementbackend.mapper.CustomerMapper;
import com.eco.cinemamanagementbackend.repository.CustomerRepository;
import com.eco.cinemamanagementbackend.repository.UserRepository;
import com.eco.cinemamanagementbackend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final PasswordEncoder passwordEncoder;

    private final CustomerMapper customerMapper;

    private final UserRepository userRepository;
    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest request) {

        Customer customer = Customer.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .avatarUrl(request.getAvatarUrl())
                .gender(request.getGender())
                .role(User.Role.CUSTOMER)
                .passwordHash((passwordEncoder.encode(request.getPassword())))
                .build();
        userRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    @Override
    public CustomerResponse getCustomerById(Integer id) {
        return null;
    }

    @Override
    public CustomerResponse updateCustomer(UpdateCustomerRequest request) {
        return null;
    }

    @Override
    public void deleteCustomer(Integer id) {

    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return List.of();
    }
}
