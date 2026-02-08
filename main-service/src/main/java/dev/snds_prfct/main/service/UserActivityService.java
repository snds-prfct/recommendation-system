package dev.snds_prfct.main.service;

import dev.snds_prfct.main.constant.UserActivityType;
import dev.snds_prfct.main.kafka.UserActivityKafkaProducer;
import dev.snds_prfct.main.model.UserActivityMessage;
import dev.snds_prfct.main.util.NumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserActivityService {

    private final UserActivityKafkaProducer userActivityKafkaProducer;

    public void registerView() {
        userActivityKafkaProducer.send(
                UserActivityMessage.of(
                        UserActivityType.VIEW,
                        "Post '%d' is viewed by user '%s'".formatted(NumberGenerator.generateNumber(), NumberGenerator.generateNumber())));
    }

    public void registerLike() {
        userActivityKafkaProducer.send(
                UserActivityMessage.of(
                        UserActivityType.LIKE,
                        "Post '%d' is liked by user '%s'".formatted(NumberGenerator.generateNumber(), NumberGenerator.generateNumber())));
    }

    public void registerRepost() {
        userActivityKafkaProducer.send(
                UserActivityMessage.of(
                        UserActivityType.REPOST,
                        "Post '%d' is reposted by user '%d'".formatted(NumberGenerator.generateNumber(), NumberGenerator.generateNumber())));
    }

}
