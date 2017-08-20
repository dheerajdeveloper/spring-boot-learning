package com.notification.controller;

import com.notification.model.Notification;
import com.notification.model.NotificationRequest;
import com.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("notification")
@RestController
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping(path = "add", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Notification addNotification(@RequestBody Notification notification) {
        Notification res = notificationService.addPackage(notification);
        return res;
    }

    @RequestMapping(path = "remove", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean removeNotification(@RequestBody Notification notification) {
        notificationService.removeNotification(notification);
        return true;
    }


    @RequestMapping(path = "send", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean sendNotification(@RequestBody NotificationRequest notificationRequest) {
        notificationService.sendNotification(notificationRequest);
        return true;
    }


}