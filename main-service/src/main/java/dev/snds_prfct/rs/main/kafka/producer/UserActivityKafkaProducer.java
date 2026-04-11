package dev.snds_prfct.rs.main.kafka.producer;

import dev.snds_prfct.rs.common.kafka.user_activity.UserActivityMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserActivityKafkaProducer {

    @Value("${kafka.topics.user-activity.topic}")
    private String topic;

    private final KafkaTemplate<String, UserActivityMessage> kafkaTemplate;

    public void send(UserActivityMessage message) {
        String key = message.type().getName();
        int partition = message.type().getPartition();
        log.debug("Sending message to partition '{}' of '{}' Kafka topic with '{}' key", partition, topic, key);
        kafkaTemplate.send(topic, partition, key, message)
                .whenComplete((r, e) -> {
                    if (e != null) {
                        log.error("Failure. Message has not been sent to '%s' Kafka topic with key '%s'".formatted(topic, key), e);
                    } else {
                        log.debug("Success. Message has been sent to '{}' Kafka topic with key '{}'", topic, key);
                    }
                });
    }
}
