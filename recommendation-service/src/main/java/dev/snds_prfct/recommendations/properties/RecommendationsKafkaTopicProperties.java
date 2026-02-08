package dev.snds_prfct.recommendations.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "kafka.topics.recommendations")
public class RecommendationsKafkaTopicProperties {
        private String topic;
        private int partitions;
}
