package com.notification.service;

import com.notification.model.*;
import com.notification.repository.ChannelRepository;
import com.notification.repository.ItemRepository;
import com.notification.repository.NotificationRepository;
import com.notification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dheeraj on 15/08/17.
 */

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;


    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    ItemRepository itemRepository;

    public User addUser(User user) {
        User data = userRepository.save(user);
        return data;
    }

    public User getUser(long id) {

        return userRepository.findOne(id);
    }

    public List<Item> getItemsForUser(long id) {
        return itemRepository.findAllByUserId(id);
    }

    public List<Channel> getChannelsForUser(long id) {
        return channelRepository.findAllByUserId(id);
    }

    public List<Notification> getNotificationsForUser(long id) {
        return notificationRepository.findAllByUserId(id);

    }

    public UserAllData getUserAllData(long id) {
        UserAllData userAllData = new UserAllData();
        User  user = userRepository.findOne(id);
        if(user == null){
            return userAllData;
        }

        userAllData.setUser(user);
        userAllData.setChannelList(channelRepository.findAllByUserId(id));
        userAllData.setItemList(itemRepository.findAllByUserId(id));
        userAllData.setNotificationList(notificationRepository.findAllByUserId(id));
        return userAllData;


    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
