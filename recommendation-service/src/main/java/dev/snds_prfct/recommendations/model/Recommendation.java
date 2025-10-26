package dev.snds_prfct.recommendations.model;

public record Recommendation(
        Long userId,
        String email,
        String recommendation) {
}
