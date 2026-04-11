package dev.snds_prfct.rs.recommendations.kafka.consumer;

import dev.snds_prfct.rs.common.kafka.user_activity.UserActivityMessage;
import dev.snds_prfct.rs.recommendations.service.UserActivityProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_PARTITION;
import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_TOPIC;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserActivityKafkaConsumer {

    private final UserActivityProcessor userActivityProcessor;

    @KafkaListener(topics = "${kafka.consumer.topics.users-activity.topic}")
    public void processUserActivityMessage(UserActivityMessage userActivityMessage,
                                           @Header(RECEIVED_TOPIC) String topic,
                                           @Header(RECEIVED_PARTITION) int partition) {
        log.info("Received message from partition '{}' of Kafka topic '{}'", partition, topic);
        userActivityProcessor.processUserActivityMessage(userActivityMessage);
    }
}
