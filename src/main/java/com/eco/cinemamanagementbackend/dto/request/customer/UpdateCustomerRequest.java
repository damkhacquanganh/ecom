package com.eco.cinemamanagementbackend.dto.request.customer;

import com.eco.cinemamanagementbackend.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateCustomerRequest {
    String fullName;
    String phone;
    String password;
    User.Gender gender;
    String avatarUrl;
    Integer loyaltyPoints;
    String membershipTier;
}
