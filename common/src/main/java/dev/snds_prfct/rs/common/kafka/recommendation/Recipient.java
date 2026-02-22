package dev.snds_prfct.rs.common.kafka.recommendation;

import lombok.Builder;

@Builder
public record Recipient(Target target,
                        UserType userType,
                        Long userId,
                        String email) {
}
