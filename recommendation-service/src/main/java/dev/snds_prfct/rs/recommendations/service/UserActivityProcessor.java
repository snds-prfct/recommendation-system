package dev.snds_prfct.rs.recommendations.service;

import dev.snds_prfct.rs.common.kafka.user_activity.UserActivityMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserActivityProcessor {

    public void processUserActivityMessage(UserActivityMessage userActivityMessage) {
        log.debug("Processing user activity message with type '{}'", userActivityMessage.type());
    }
}
