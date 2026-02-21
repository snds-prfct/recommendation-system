package dev.snds_prfct.recommendations.service;

import dev.snds_prfct.recommendations.kafka.producer.RecommendationsKafkaProducer;
import dev.snds_prfct.rs.common.recommendation.message.RecommendationMessage;
import dev.snds_prfct.recommendations.util.NumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationsKafkaProducer recommendationsKafkaProducer;

    @Scheduled(fixedDelay = 5000)
    public void sendRecommendation() {
        recommendationsKafkaProducer.send(getRecommendation());
    }

    private RecommendationMessage getRecommendation() {
        long userId = NumberGenerator.generateNumber();
        String email = userId + "@mail.dev";
        return RecommendationMessage.of(userId, email, "Some recommendation");
    }
}
