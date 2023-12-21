package com.mrani.ratelimiter.service;

import com.mrani.ratelimiter.exceptions.WorkFlowPreemptionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author manjushaRani
 */

@Service
@Slf4j
public class RateLimitHandler {
    private final RedisTemplate<String, String> redisTemplate;

    public RateLimitHandler(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void waitOrThrowOnAPIRateLimits() {
        if (isAPIRateLimited()) {
            throw new WorkFlowPreemptionException("Rate limit hit for api");
        }
    }

    public boolean isAPIRateLimited() {
        return false;
    }
}
