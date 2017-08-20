package com.notification.helper;

import com.notification.model.Item;
import com.notification.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dheeraj on 15/08/17.
 */
public class WebChannelNotifier extends ChannelNotifier {

    Logger LOGGER = LoggerFactory.getLogger(WebChannelNotifier.class);

    @Override
    public boolean sendNotification(Item item, User user) {

        LOGGER.info("Successfully sent notification for user {} , " +
                "item {} over WEB channel " , user , item);
        return true;
    }


}
