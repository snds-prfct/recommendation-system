package dev.snds_prfct.rs.main;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = "kafka.topics.users-activity.topic")
class MainApplicationTest {

    @Test
    void testAppStarts() {
    }
}