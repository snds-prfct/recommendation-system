package dev.snds_prfct.rs.main.kafka.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "kafka.topics.users-activity")
public class UserActivityKafkaProperties {
    private String topic;
    private int partitions;
}
