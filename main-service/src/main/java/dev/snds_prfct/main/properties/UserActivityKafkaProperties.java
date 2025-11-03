package dev.snds_prfct.main.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "user-activity.kafka.producer")
public class UserActivityKafkaProperties {
    private String topic;
}
