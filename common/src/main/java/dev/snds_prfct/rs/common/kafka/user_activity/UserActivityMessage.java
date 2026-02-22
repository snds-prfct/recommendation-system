package dev.snds_prfct.rs.common.kafka.user_activity;

import java.time.Instant;

public record UserActivityMessage(
        Long userId,
        UserActivityType type,
        String message,
        Instant timestamp) {

    public static UserActivityMessage of(Long userId, UserActivityType type, String message) {
        return new UserActivityMessage(userId, type, message, Instant.now());
    }
}
