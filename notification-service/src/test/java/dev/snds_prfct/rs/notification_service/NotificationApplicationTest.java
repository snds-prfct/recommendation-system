package dev.snds_prfct.rs.notification_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"${kafka.consumers.topics.recommendations.topic}"})
public class NotificationApplicationTest {

    @Test
    void testAppStarts() {
    }

}
