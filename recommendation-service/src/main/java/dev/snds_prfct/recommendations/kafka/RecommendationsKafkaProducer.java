package dev.snds_prfct.recommendations.kafka;

import dev.snds_prfct.recommendations.model.RecommendationMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RecommendationsKafkaProducer {

    @Value("${kafka.topics.recommendations.topic}")
    private String topic;

    private final KafkaTemplate<Long, RecommendationMessage> recommendationKafkaTemplate;

    public void send(RecommendationMessage message) {
        log.debug("Sending message to '{}' kafka topic", topic);
        recommendationKafkaTemplate.send(topic, message)
                .whenComplete((r, e) -> {
                    if (e != null) {
                        log.error("Message has not been sent to '%s' Kafka topic".formatted(topic), e);
                    } else {
                        log.debug("Message has been sent to '%s' Kafka topic".formatted(topic));
                    }
                });
    }
}
