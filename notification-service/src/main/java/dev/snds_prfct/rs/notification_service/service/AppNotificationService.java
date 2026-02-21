package dev.snds_prfct.rs.notification_service.service;

import dev.snds_prfct.rs.notification_service.notification.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AppNotificationService implements NotificationService {
    @Override
    public void send(Notification notification) {
        log.debug("Sending notifications");
    }
}
