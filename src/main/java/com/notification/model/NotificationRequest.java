package com.notification.model;

import com.notification.enums.NotificationEvent;

/**
 * Created by dheeraj on 15/08/17.
 */
public class NotificationRequest {
    long itemId;
    NotificationEvent notificationEvent;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public NotificationEvent getNotificationEvent() {
        return notificationEvent;
    }

    public void setNotificationEvent(NotificationEvent notificationEvent) {
        this.notificationEvent = notificationEvent;
    }
}
