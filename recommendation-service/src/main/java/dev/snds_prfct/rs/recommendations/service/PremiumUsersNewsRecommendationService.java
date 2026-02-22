package dev.snds_prfct.rs.recommendations.service;

import dev.snds_prfct.rs.common.kafka.recommendation.Recipient;
import dev.snds_prfct.rs.common.kafka.recommendation.Recommendation;
import dev.snds_prfct.rs.common.kafka.recommendation.RecommendationMessage;
import dev.snds_prfct.rs.common.kafka.recommendation.RecommendationType;
import dev.snds_prfct.rs.common.kafka.recommendation.Target;
import dev.snds_prfct.rs.common.kafka.recommendation.UserType;
import dev.snds_prfct.rs.recommendations.kafka.producer.RecommendationKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class PremiumUsersNewsRecommendationService implements RecommendationService {

    private final RecommendationKafkaProducer recommendationKafkaProducer;

    @Override
    @Scheduled(fixedDelay = 50000)
    public void createRecommendation() {
        recommendationKafkaProducer.send(getRecommendation());
    }

    protected RecommendationMessage getRecommendation() {
        return RecommendationMessage.builder()
                .recipient(Recipient.builder()
                        .target(Target.MULTIPLE_USERS)
                        .userType(UserType.PREMIUM)
                        .build())
                .recommendation(Recommendation.builder()
                        .type(RecommendationType.NEWS)
                        .message("News Recommendation!")
                        .build())
                .createdAt(Instant.now())
                .build();
    }
}
