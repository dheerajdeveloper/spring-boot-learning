package com.notification.helper;

import com.notification.model.Item;
import com.notification.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dheeraj on 15/08/17.
 */
public class SmsChannelNotifier extends ChannelNotifier {
    Logger LOGGER = LoggerFactory.getLogger(SmsChannelNotifier.class);


    @Override
    public boolean sendNotification(Item item, User user) {

        LOGGER.info("Successfully sent notification for user {} , " +
                "item {} over SMS channel " , user , item);


        return true;
    }
}
