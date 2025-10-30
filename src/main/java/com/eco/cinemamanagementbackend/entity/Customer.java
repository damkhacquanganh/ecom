package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "customers")
public class Customer extends User {
    Integer loyaltyPoints = 0;

    @Enumerated(EnumType.STRING)
    MembershipTier membershipTier = MembershipTier.BRONZE;

    public enum MembershipTier {
        BRONZE, SILVER, GOLD, PLATINUM
    }
}