package dev.snds_prfct.rs.common.kafka.recommendation;

import lombok.Builder;

import java.time.Instant;

@Builder
public record RecommendationMessage(
        Recipient recipient,
        Recommendation recommendation,
        Instant createdAt) {
}
