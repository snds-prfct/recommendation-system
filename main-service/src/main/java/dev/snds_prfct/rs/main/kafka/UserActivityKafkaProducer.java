package dev.snds_prfct.main.kafka;

import dev.snds_prfct.rs.common.recommendation.message.UserActivityMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserActivityKafkaProducer {

    @Value("${kafka.topics.users-activity.topic}")
    private String topic;

    private final KafkaTemplate<String, UserActivityMessage> kafkaTemplate;

    public void send(UserActivityMessage message) {
        log.debug("Sending message to '%s' Kafka topic with '%s' key".formatted(topic, message.type().getName()));
        kafkaTemplate.send(topic, message.type().getName(), message)
                .whenComplete((r, e) -> {
                    if (e != null) {
                        log.error("Message has not been sent to '%s' Kafka topic".formatted(topic), e);
                    } else {
                        log.debug("Message has been sent to '%s' Kafka topic".formatted(topic));
                    }
                });
    }
}
