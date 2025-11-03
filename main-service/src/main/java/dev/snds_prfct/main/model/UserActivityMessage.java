package dev.snds_prfct.main.model;

import java.time.Instant;

public record UserActivityMessage(
        String message,
        Instant timestamp
) {
}
