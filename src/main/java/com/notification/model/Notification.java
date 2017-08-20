package com.notification.model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.cglib.core.GeneratorStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by dheeraj on 15/08/17.
 */

@Entity
public class Notification {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String notificationType;

    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;

    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", notificationType='" + notificationType + '\'' +
                ", userId=" + userId +
                '}';
    }
}
