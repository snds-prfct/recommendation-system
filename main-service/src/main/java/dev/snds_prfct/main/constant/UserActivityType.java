package dev.snds_prfct.main.constant;

public enum UserActivityType {
    VIEW("view"), LIKE("like"), REPOST("repost");

    private final String name;

    UserActivityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
