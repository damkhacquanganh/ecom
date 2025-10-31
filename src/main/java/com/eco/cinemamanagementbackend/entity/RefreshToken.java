package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
@Table(name ="refreshToken")
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, unique = true)
    String token;

    @ManyToOne()
    @JoinColumn(name ="user_id" , nullable = false)
    User user;

    @CreationTimestamp
    LocalDateTime createdAt;// thio gian tao

    LocalDateTime expiresAt; //Thoi gian het han

    boolean revoked = false;  //danh giau token co lam moi duoc hay khong
}
