package com.eco.cinemamanagementbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    /**
     * Blacklist token với TTL = thời gian còn lại của token để tự expire.
     * @param token Token cần blacklist
     * @param expirationMs Thời gian expire còn lại (ms)
     */
    public void blacklistToken(String token, long expirationMs) {
        redisTemplate.opsForValue().set("blacklist:" + token, "revoked", expirationMs, TimeUnit.MILLISECONDS);
    }

    /**
     * Check token có trong blacklist không.
     * @param token Token cần check
     * @return true nếu blacklisted
     */
    public boolean isBlacklisted(String token) {
        return Boolean.TRUE.equals(redisTemplate.hasKey("blacklist:" + token));
    }
}