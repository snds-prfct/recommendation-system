package dev.snds_prfct.rs.common.kafka.user_activity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum UserActivityType {
    VIEW("view", 0),
    LIKE("like", 1),
    REPOST("repost", 2);

    private final String name;
    private final int partition;

}
