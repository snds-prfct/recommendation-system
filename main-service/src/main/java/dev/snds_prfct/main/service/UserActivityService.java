package dev.snds_prfct.main.service;

import dev.snds_prfct.main.constant.UserActivityType;
import dev.snds_prfct.main.queue.UserActivityKafkaProducer;
import dev.snds_prfct.main.util.NumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserActivityService {

    private final UserActivityKafkaProducer userActivityKafkaProducer;
    private final NumberGenerator numberGenerator;

    public void registerView() {
        userActivityKafkaProducer.send(
                UserActivityType.VIEW.getName(),
                "Post '%d' is viewed by user '%s'".formatted(numberGenerator.generateNumber(), numberGenerator.generateNumber()));
    }

    public void registerLike() {
        userActivityKafkaProducer.send(
                UserActivityType.LIKE.getName(),
                "Post '%d' is liked by user '%s'".formatted(numberGenerator.generateNumber(), numberGenerator.generateNumber()));
    }

    public void registerRepost() {
        userActivityKafkaProducer.send(
                UserActivityType.REPOST.getName(),
                "Post '%d' is reposted by user '%d'".formatted(numberGenerator.generateNumber(), numberGenerator.generateNumber()));
    }

}
