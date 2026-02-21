package dev.snds_prfct.rs.notification_service.service;

import dev.snds_prfct.rs.notification_service.notification.Notification;

public interface NotificationService {
    void send(Notification notification);
}
