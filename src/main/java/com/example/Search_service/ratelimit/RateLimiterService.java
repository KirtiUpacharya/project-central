package com.example.Search_service.ratelimit;
//Using Redis-backed Token Bucket Algorithm
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class RateLimiterService {

    private static final int MAX_REQUESTS_PER_MINUTE = 100; // limit per user

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public boolean isAllowed(String userId) {
        String redisKey = "rate_limit:" + userId;
        Long currentCount = redisTemplate.opsForValue().increment(redisKey, 1);

        if (currentCount == 1) {
            redisTemplate.expire(redisKey, 1, TimeUnit.MINUTES);
        }

        return currentCount <= MAX_REQUESTS_PER_MINUTE;
    }
}

