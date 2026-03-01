package dev.snds_prfct.rs.recommendations.configuration;

import dev.snds_prfct.rs.recommendations.properties.RecommendationsKafkaTopicProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableConfigurationProperties(RecommendationsKafkaTopicProperties.class)
@RequiredArgsConstructor
@EnableKafka
public class KafkaConfiguration {

    private final RecommendationsKafkaTopicProperties recommendationsKafkaTopicProperties;

    @Bean
    public NewTopic recommendationsKafkaTopic() {
        return TopicBuilder
                .name(recommendationsKafkaTopicProperties.getTopic())
                .partitions(recommendationsKafkaTopicProperties.getPartitions())
                .build();
    }
}
