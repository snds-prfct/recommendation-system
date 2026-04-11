package dev.snds_prfct.rs.notification_service.processor;

import dev.snds_prfct.rs.common.kafka.recommendation.RecommendationMessage;
import dev.snds_prfct.rs.notification_service.notification.Notification;
import dev.snds_prfct.rs.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecommendationProcessor {

    private final NotificationService notificationService;

    public void process(RecommendationMessage recommendationMessage) {
        log.debug("Processing next recommendation message with type '{}'", recommendationMessage.recommendation().type());
        notificationService.send(new Notification());
        log.debug("Recommendation message has been processed");
    }
}
