package dev.snds_prfct.main.kafka;

import dev.snds_prfct.main.model.UserActivityMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserActivityKafkaProducer {

    @Value("${user-activity.kafka.producer.topic}")
    private String topic;

    private final KafkaTemplate<String, UserActivityMessage> kafkaTemplate;

    public void send(String key, String message) {
        UserActivityMessage userActivityMessage = new UserActivityMessage(message, Instant.now());

        log.info("Sending message to '%s' Kafka topic with '%s' key".formatted(topic, key));
        kafkaTemplate.send(topic, key, userActivityMessage)
                .whenComplete((r, e) -> {
                    if (e != null) {
                        log.info("Message has not been sent", e);
                    } else {
                        log.info("Message has been sent");
                    }
                });
    }
}
