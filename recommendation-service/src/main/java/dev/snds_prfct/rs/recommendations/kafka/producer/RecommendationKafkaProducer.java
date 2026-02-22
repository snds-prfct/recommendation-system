package dev.snds_prfct.rs.recommendations.kafka.producer;

import dev.snds_prfct.rs.common.kafka.recommendation.RecommendationMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RecommendationKafkaProducer {

    @Value("${kafka.producer.topics.recommendations.topic}")
    private String topic;

    private final KafkaTemplate<String, RecommendationMessage> recommendationKafkaTemplate;

    public void send(RecommendationMessage message) {
        String key = message.recommendation().type().getType();
        log.debug("Sending message to '{}' Kafka topic with key '{}'", topic, key);
        recommendationKafkaTemplate.send(topic, message.recommendation().type().getPartition(), key, message)
                .whenComplete((r, e) -> {
                    if (e != null) {
                        log.error("Failure. Message has not been sent to '%s' Kafka topic with key '%s'".formatted(topic, key), e);
                    } else {
                        log.debug("Success. Message has been sent to '{}' Kafka topic with key '{}'", topic, key);
                    }
                });
    }
}
