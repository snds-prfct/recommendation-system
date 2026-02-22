package dev.snds_prfct.rs.common.utils;

import java.util.Random;

public class NumberGenerator {

    private static final Random RANDOM = new Random();

    public static Long generateNumber() {
        return RANDOM.nextLong(1_000_000) + 1;
    }
}
