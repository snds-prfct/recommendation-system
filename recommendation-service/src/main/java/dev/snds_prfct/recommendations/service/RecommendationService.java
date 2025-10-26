package dev.snds_prfct.recommendations.service;

import dev.snds_prfct.recommendations.model.Recommendation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    @Value("${recommendations.kafka.producer.topic}")
    private String recommendationsTopic;
    private final Random random = new Random();

    private final KafkaTemplate<Long, Recommendation> recommendationKafkaTemplate;

    @Scheduled(fixedDelay = 5000)
    public void sendRecommendation() {
        System.out.println("Sending message to Kafka");
        CompletableFuture<SendResult<Long, Recommendation>> sentMessage = recommendationKafkaTemplate.send(recommendationsTopic, getRecommendation());

        try {
            sentMessage.get();
            System.out.println("Message has been sent");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Message has not been sent");
            throw new RuntimeException(e);
        }
    }

    private Recommendation getRecommendation() {
        long userId = random.nextLong(1_000_000) + 1;
        String email = userId + "@mail.com";
        return new Recommendation(userId, email, "Some recommendation");
    }
}
