package com.notification.service;

import com.notification.enums.NotificationChannel;
import com.notification.helper.ChannelNotifier;
import com.notification.model.*;
import com.notification.repository.ChannelRepository;
import com.notification.repository.ItemRepository;
import com.notification.repository.NotificationRepository;
import com.notification.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dheeraj on 15/08/17.
 */

@Service
public class NotificationService {

    Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;


    @Autowired
    ChannelRepository channelRepository;


    public Notification addPackage(Notification notification) {

        if (notification == null) {
            return notification;

        }
        Notification notification1 = notificationRepository.findFirstByUserIdAndNotificationType(
                notification.getUserId(), notification.getNotificationType());

        if (notification1 != null) {
            return notification1;
        }

        return notificationRepository.save(notification);
    }

    public void removeNotification(Notification notification) {
        if (notification == null) {
            return;

        }
        Notification notification1 = notificationRepository.findFirstByUserIdAndNotificationType(
                notification.getUserId(), notification.getNotificationType());

        if (notification1 != null) {
            notificationRepository.delete(notification1);
        }
    }

    public void sendNotification(NotificationRequest notificationRequest) {

        Item item = itemRepository.findOne(notificationRequest.getItemId());

        if (item == null) {
            LOGGER.info("No Item for this item id. returning {}", notificationRequest);
            return;
        }

        final User user = userRepository.findOne(item.getUserId());

        if (user == null) {
            LOGGER.info("No user for this user id. returning {}", notificationRequest);
            return;
        }

        Notification notification = notificationRepository.findFirstByUserIdAndNotificationType(user.getId(),
                notificationRequest.getNotificationEvent().toString());

        if (notification == null) {
            LOGGER.info("No notification for this user id and notification {}", notificationRequest);
            return;
        }

        List<Channel> channelList = channelRepository.findAllByUserId(user.getId());

        /*
        if channel list is empty then we will send notificaiton
        to email and sms
         */
        if(CollectionUtils.isEmpty(channelList)){
            channelList = new ArrayList<Channel>(){{
                add(createChannel(NotificationChannel.EMAIL, user));
                add(createChannel(NotificationChannel.SMS, user));
            }};
        }

        for(ChannelNotifier channelNotifier : ChannelNotifier.getChannels(channelList)){
            channelNotifier.sendNotification(item, user);
        }


    }

    private Channel createChannel(NotificationChannel notificationChannel, User user) {
        Channel channel = new Channel();
        channel.setChannel(notificationChannel);
        channel.setUserId(user.getId());

        return channel;
    }
}
