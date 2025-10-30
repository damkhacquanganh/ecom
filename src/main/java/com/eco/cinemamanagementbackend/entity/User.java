package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String fullName;

    @Column(unique = true)
    String email;

    @Column(unique = true, nullable = false)
    String phone;

    @Column(nullable = false)
    String passwordHash;

    LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    Gender gender;

    String avatarUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Role role;

    boolean isVerified = false;

    LocalDateTime lastLogin;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public enum Role {
        CUSTOMER, EMPLOYEE, ADMIN, MANAGER, CASHIER, USHER, TECHNICIAN
    }
}