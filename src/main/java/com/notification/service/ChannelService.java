package com.notification.service;

import com.notification.model.Channel;
import com.notification.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dheeraj on 15/08/17.
 */

@Service
public class ChannelService {

    @Autowired
    ChannelRepository channelRepository;


    public Channel addChannel(Channel channel) {

        if(channel == null ){
            return null;
        }
        Channel channel1 = channelRepository.findByUserIdAndChannel(channel.getUserId() , channel.getChannel());

        if(channel1 != null){
            return channel1;
        }

        return channelRepository.save(channel);
    }

    public void removeChannel(Channel channel) {
        if(channel == null ){
            return;
        }
        Channel channel1 = channelRepository.findByUserIdAndChannel(channel.getUserId() , channel.getChannel());

        if(channel1 != null){
            channelRepository.delete(channel1);
        }
    }
}
