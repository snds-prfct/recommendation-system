package dev.snds_prfct.main.constant;

import lombok.Getter;

@Getter
public enum UserActivityType {
    VIEW("view"), LIKE("like"), REPOST("repost");

    private final String name;

    UserActivityType(String name) {
        this.name = name;
    }

}
