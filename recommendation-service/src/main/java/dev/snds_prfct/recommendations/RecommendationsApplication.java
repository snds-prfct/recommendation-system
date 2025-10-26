package dev.snds_prfct.recommendations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RecommendationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecommendationsApplication.class, args);
    }
}