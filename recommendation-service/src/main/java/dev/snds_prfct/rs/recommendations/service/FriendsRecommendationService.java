package dev.snds_prfct.rs.recommendations.service;

import dev.snds_prfct.rs.common.kafka.recommendation.Recipient;
import dev.snds_prfct.rs.common.kafka.recommendation.Recommendation;
import dev.snds_prfct.rs.common.kafka.recommendation.RecommendationMessage;
import dev.snds_prfct.rs.common.kafka.recommendation.RecommendationType;
import dev.snds_prfct.rs.common.kafka.recommendation.Target;
import dev.snds_prfct.rs.common.utils.NumberGenerator;
import dev.snds_prfct.rs.recommendations.kafka.producer.RecommendationKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class FriendsRecommendationService implements RecommendationService {

    private final RecommendationKafkaProducer specificUserRecommendationKafkaProducer;

    @Override
    @Scheduled(fixedDelayString = "${scheduling.recommendations.friends.fixed-delay-millis}")
    public void createRecommendation() {
        specificUserRecommendationKafkaProducer.send(generateRecommendation());
    }

    protected RecommendationMessage generateRecommendation() {
        long userId = NumberGenerator.generateNumber();
        String email = userId + "@mail.dev";
        return RecommendationMessage.builder()
                .recipient(Recipient.builder()
                        .target(Target.SPECIFIC_USER)
                        .userId(userId)
                        .email(email)
                        .build())
                .recommendation(Recommendation.builder()
                        .type(RecommendationType.FRIENDS)
                        .message("New Friends Recommendation!")
                        .build())
                .createdAt(Instant.now())
                .build();
    }
}
