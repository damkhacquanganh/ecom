package com.eco.cinemamanagementbackend.dto.response.customer;

import com.eco.cinemamanagementbackend.entity.Customer;
import com.eco.cinemamanagementbackend.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {
    Integer id;
    String fullName;
    String email;
    String phone;
    LocalDate dateOfBirth;
    User.Gender gender;
    String avatarUrl;
    String role; // Từ User.Role
    boolean isVerified;
    LocalDateTime lastLogin;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Integer loyaltyPoints;
    Customer.MembershipTier membershipTier;
}
