package dev.snds_prfct.rs.recommendations;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(
        partitions = 1,
        topics = {
                "${kafka.consumer.topics.users-activity.topic}",
                "${kafka.producer.topics.recommendations.topic}"
        }
)
class RecommendationsApplicationTest {

    @Test
    void testAppStarts() {
    }
}