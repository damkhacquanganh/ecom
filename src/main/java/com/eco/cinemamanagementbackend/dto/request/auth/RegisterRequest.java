package com.eco.cinemamanagementbackend.dto.request.auth;

import com.eco.cinemamanagementbackend.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String fullName;
    String password;
    String email;
    String phone;
    User.Gender gender;
    LocalDate dateOfBirth;
}
