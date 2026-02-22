package dev.snds_prfct.rs.common.kafka.recommendation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RecommendationType {
    NEWS("news", 0),
    FRIENDS("friends", 1),
    POSTS("posts", 2);

    private final String type;
    private final int partition;
}
