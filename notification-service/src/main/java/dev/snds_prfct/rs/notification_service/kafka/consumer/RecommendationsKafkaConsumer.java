package dev.snds_prfct.rs.notification_service.kafka.consumer;

import dev.snds_prfct.rs.common.kafka.recommendation.RecommendationMessage;
import dev.snds_prfct.rs.notification_service.processor.RecommendationProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_PARTITION;
import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_TOPIC;

@Slf4j
@Component
@RequiredArgsConstructor
public class RecommendationsKafkaConsumer {

    private final RecommendationProcessor recommendationProcessor;

    @KafkaListener(topics = "${kafka.consumers.topics.recommendations.topic}")
    public void processRecommendationMessage(RecommendationMessage recommendationMessage,
                                             @Header(RECEIVED_TOPIC) String topic,
                                             @Header(RECEIVED_PARTITION) int partition) {
        log.info("Received message from partition '{}' of Kafka topic '{}'", partition, topic);
        recommendationProcessor.process(recommendationMessage);
    }
}
