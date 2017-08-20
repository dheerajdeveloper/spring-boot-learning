package com.notification.model;

import java.util.List;

/**
 * Created by dheeraj on 15/08/17.
 */
public class UserAllData {

    User user;
    List<Item> itemList;
    List<Channel> channelList;
    List<Notification> notificationList;

    @Override
    public String toString() {
        return "UserAllData{" +
                "user=" + user +
                ", itemList=" + itemList +
                ", channelList=" + channelList +
                ", notificationList=" + notificationList +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }
}
