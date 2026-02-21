package dev.snds_prfct.rs.notification_service.kafka.consumer;

import dev.snds_prfct.rs.common.recommendation.message.RecommendationMessage;
import dev.snds_prfct.rs.notification_service.processor.RecommendationProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RecommendationsKafkaConsumer {

    private final RecommendationProcessor recommendationProcessor;

    @KafkaListener(topics = "${kafka.consumers.recommendations.topic}")
    public void processRecommendationMessage(RecommendationMessage recommendationMessage) {
        log.info("Consuming message: {}", recommendationMessage);
        recommendationProcessor.process(recommendationMessage);
    }
}
