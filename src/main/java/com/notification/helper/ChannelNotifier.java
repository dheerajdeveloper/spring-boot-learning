package com.notification.helper;

import com.notification.enums.NotificationChannel;
import com.notification.model.Channel;
import com.notification.model.Item;
import com.notification.model.User;
import org.hibernate.usertype.LoggableUserType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dheeraj on 15/08/17.
 */
public abstract class ChannelNotifier {

    private final static Map<NotificationChannel, ChannelNotifier> m
            = new HashMap<NotificationChannel, ChannelNotifier>() {{
        put(NotificationChannel.SMS, new SmsChannelNotifier());
        put(NotificationChannel.WEB, new WebChannelNotifier());
        put(NotificationChannel.EMAIL, new EmailChannelNotifier());
    }};

    public static List<ChannelNotifier> getChannels(List<Channel> channelList) {

        List<ChannelNotifier> channelNotifierList = new ArrayList<ChannelNotifier>();

        for (Channel channel : channelList) {
            channelNotifierList.add(m.get(channel.getChannel()));
        }

        return channelNotifierList;
    }

    public abstract boolean sendNotification(Item item, User user);
}
