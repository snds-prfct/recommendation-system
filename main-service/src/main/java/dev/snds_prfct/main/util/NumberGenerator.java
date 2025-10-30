package dev.snds_prfct.main.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGenerator {

    private final Random random = new Random();

    public Long generateNumber() {
        return random.nextLong(1_000_000) + 1;
    }
}
