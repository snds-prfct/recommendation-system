package dev.snds_prfct.main.model;

import dev.snds_prfct.main.constant.UserActivityType;

import java.time.Instant;

public record UserActivityMessage(
        UserActivityType type,
        String message,
        Instant timestamp
) {
    public static UserActivityMessage of(UserActivityType type, String message) {
        return new UserActivityMessage(type, message, Instant.now());
    }
}
