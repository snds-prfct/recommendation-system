package dev.snds_prfct.rs.common.recommendation.message;

import java.time.Instant;

public record RecommendationMessage(
        Long userId,
        String email,
        String recommendation,
        Instant timestamp) {

    public static RecommendationMessage of(Long userId,
                                           String email,
                                           String recommendation) {
        return new RecommendationMessage(userId, email, recommendation, Instant.now());
    }
}
