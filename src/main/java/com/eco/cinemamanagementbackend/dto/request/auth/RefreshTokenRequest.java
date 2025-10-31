package com.eco.cinemamanagementbackend.dto.request.auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class RefreshTokenRequest {
    String refreshToken;
}
