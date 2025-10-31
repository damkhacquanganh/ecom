package com.eco.cinemamanagementbackend.controller;

import com.eco.cinemamanagementbackend.config.JwtTokenProvider;
import com.eco.cinemamanagementbackend.dto.common.ApiResponse;

import com.eco.cinemamanagementbackend.dto.request.auth.LoginRequest;
import com.eco.cinemamanagementbackend.dto.request.auth.RefreshTokenRequest;
import com.eco.cinemamanagementbackend.dto.request.auth.RegisterRequest;
import com.eco.cinemamanagementbackend.dto.response.auth.AuthResponse;
import com.eco.cinemamanagementbackend.entity.Customer;
import com.eco.cinemamanagementbackend.entity.RefreshToken;
import com.eco.cinemamanagementbackend.entity.User;
import com.eco.cinemamanagementbackend.exception.CustomExceptions;
import com.eco.cinemamanagementbackend.repository.RefreshTokenRepository;
import com.eco.cinemamanagementbackend.repository.UserRepository;
import com.eco.cinemamanagementbackend.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final RedisService redisService;  // Inject RedisService
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        String accessToken = jwtTokenProvider.generateAccessToken(authentication);
        String refreshToken = jwtTokenProvider.generateRefreshToken(authentication.getName());

        // Lưu refresh token vào DB
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomExceptions.AuthenticationException("Invalid credentials"));
        RefreshToken rt = RefreshToken.builder()
                .token(refreshToken)
                .user(user)
                .expiresAt(LocalDateTime.now().plusDays(7))
                .build();
        refreshTokenRepository.save(rt);

        AuthResponse response = new AuthResponse(accessToken, refreshToken);
        return ApiResponse.success(response, "Login successful");
    }

    @PostMapping("/register")
    public ApiResponse<User> register(@RequestBody RegisterRequest request) {
        // Check duplicate (thực tế: add @Valid và service validation)
        if (userRepository.findByEmail(request.getEmail()).isPresent() || userRepository.findByPhone(request.getPhone()).isPresent()) {
            throw new CustomExceptions.DuplicateResourceException("Email or phone already exists");
        }

        // Default Customer
        Customer customer = Customer.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .dateOfBirth(request.getDateOfBirth())
                .gender(request.getGender())
                .role(User.Role.CUSTOMER)
                .build();
        userRepository.save(customer);
        return ApiResponse.success(customer, "Registration successful");
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout(@RequestBody RefreshTokenRequest request, @RequestHeader("Authorization") String authHeader) {
        // Revoke refresh token trong DB
        refreshTokenRepository.findByToken(request.getRefreshToken())
                .ifPresent(rt -> {
                    rt.setRevoked(true);
                    refreshTokenRepository.save(rt);
                });

        // Blacklist access token trong Redis (lấy từ header)
        String accessToken = authHeader.replace("Bearer ", "");
        long expirationMs = jwtTokenProvider.getExpirationFromToken(accessToken);  // Method mới trong JwtTokenProvider để lấy exp time
        redisService.blacklistToken(accessToken, expirationMs);

        return ApiResponse.success(null, "Logout successful");
    }

    @PostMapping("/refresh")
    public ApiResponse<AuthResponse> refresh(@RequestBody RefreshTokenRequest request) {
        RefreshToken rt = refreshTokenRepository.findByToken(request.getRefreshToken())
                .orElseThrow(() -> new CustomExceptions.AuthenticationException("Invalid refresh token"));

        if (rt.isRevoked() || rt.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new CustomExceptions.AuthenticationException("Refresh token expired or revoked");
        }

        String username = jwtTokenProvider.getUsernameFromToken(request.getRefreshToken());
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, null);
        String newAccessToken = jwtTokenProvider.generateAccessToken(authentication);

        AuthResponse response = new AuthResponse(newAccessToken, request.getRefreshToken());
        return ApiResponse.success(response, "Token refreshed");
    }
}