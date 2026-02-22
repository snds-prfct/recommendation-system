package dev.snds_prfct.rs.main.service;

import dev.snds_prfct.rs.common.kafka.user_activity.UserActivityMessage;
import dev.snds_prfct.rs.common.kafka.user_activity.UserActivityType;
import dev.snds_prfct.rs.common.utils.NumberGenerator;
import dev.snds_prfct.rs.main.kafka.UserActivityKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserActivityService {

    private final UserActivityKafkaProducer userActivityKafkaProducer;

    public void registerView() {
        Long userId = NumberGenerator.generateNumber();
        userActivityKafkaProducer.send(
                UserActivityMessage.of(
                        userId,
                        UserActivityType.VIEW,
                        "Post '%d' is viewed by user '%s'".formatted(NumberGenerator.generateNumber(), userId)));
    }

    public void registerLike() {
        Long userId = NumberGenerator.generateNumber();
        userActivityKafkaProducer.send(
                UserActivityMessage.of(
                        userId,
                        UserActivityType.LIKE,
                        "Post '%d' is liked by user '%s'".formatted(NumberGenerator.generateNumber(), userId)));
    }

    public void registerRepost() {
        Long userId = NumberGenerator.generateNumber();
        userActivityKafkaProducer.send(
                UserActivityMessage.of(
                        userId,
                        UserActivityType.REPOST,
                        "Post '%d' is reposted by user '%d'".formatted(NumberGenerator.generateNumber(), userId)));
    }

}
