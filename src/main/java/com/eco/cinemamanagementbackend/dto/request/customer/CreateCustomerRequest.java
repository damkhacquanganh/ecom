package com.eco.cinemamanagementbackend.dto.request.customer;

import com.eco.cinemamanagementbackend.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCustomerRequest {
    String fullName;
    String email;
    String phone;
    User.Gender gender;
    String password;
    String avatarUrl;
}
