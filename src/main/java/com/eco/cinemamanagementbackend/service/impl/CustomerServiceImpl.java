package com.eco.cinemamanagementbackend.service.impl;

import com.eco.cinemamanagementbackend.dto.request.customer.CreateCustomerRequest;
import com.eco.cinemamanagementbackend.dto.request.customer.UpdateCustomerRequest;
import com.eco.cinemamanagementbackend.dto.response.customer.CustomerResponse;
import com.eco.cinemamanagementbackend.entity.Customer;
import com.eco.cinemamanagementbackend.entity.User;
import com.eco.cinemamanagementbackend.exception.CustomExceptions;
import com.eco.cinemamanagementbackend.mapper.CustomerMapper;
import com.eco.cinemamanagementbackend.repository.UserRepository;
import com.eco.cinemamanagementbackend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
        Customer customer = (Customer) userRepository.findById(id)
                .filter(user -> user instanceof Customer)
                .orElseThrow(() ->new CustomExceptions.NotFoundException("Customer not found"));
        return customerMapper.toDto(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers= userRepository.findAll().stream()
                .filter(user -> user instanceof Customer && user.getRole() == User.Role.CUSTOMER )
                .map(user ->(Customer) user)
                .collect(Collectors.toList());
        return customerMapper.toDtoList(customers);
    }

    @Override
    public CustomerResponse updateCustomer(Integer id, UpdateCustomerRequest request) {
        Customer customer = (Customer) userRepository.findById(id)
                .filter(user -> user instanceof Customer)
                .orElseThrow(() -> new CustomExceptions.NotFoundException("Customer not found"));

        if(request.getFullName() != null) customer.setFullName(request.getFullName());
        if(request.getPhone() != null) customer.setPhone(request.getPhone());
        if(request.getAvatarUrl() != null) customer.setAvatarUrl(request.getAvatarUrl());
        if(request.getGender() != null) customer.setGender(request.getGender());
        if(request.getPassword() != null) customer.setPasswordHash(passwordEncoder.encode(request.getPassword()));

        // Cần xem xét lại nếu có buff cho người dùng update qua api.
        if(request.getLoyaltyPoints() != null) customer.setLoyaltyPoints(request.getLoyaltyPoints());
        if(request.getMembershipTier()!=null) customer.setMembershipTier(Customer.MembershipTier.valueOf(request.getMembershipTier().toUpperCase()));

        userRepository.save(customer);
        return customerMapper.toDto(customer);
    }


    @Override
    public void deleteCustomer(Integer id) {
        Customer customer = (Customer) userRepository.findById(id)
                .filter(user -> user instanceof Customer)
                .orElseThrow(() -> new CustomExceptions.NotFoundException("Customer not found"));
        userRepository.delete(customer);
    }


}
