package dev.snds_prfct.main.configuration;

import dev.snds_prfct.main.properties.UserActivityKafkaProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableConfigurationProperties(UserActivityKafkaProperties.class)
@RequiredArgsConstructor
public class KafkaConfiguration {

    private final UserActivityKafkaProperties userActivityKafkaProperties;

    @Bean
    public NewTopic userActivityKafkaTopic() {
        return TopicBuilder
                .name(userActivityKafkaProperties.getTopic())
                .partitions(3)
                .build();
    }
}
