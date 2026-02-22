package dev.snds_prfct.rs.common.kafka.recommendation;

import lombok.Builder;

@Builder
public record Recommendation(RecommendationType type,
                             String message) {
}
