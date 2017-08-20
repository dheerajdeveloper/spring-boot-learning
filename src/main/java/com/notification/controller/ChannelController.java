package com.notification.controller;

import com.notification.model.Channel;
import com.notification.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("channel")
@RestController
public class ChannelController {

    @Autowired
    ChannelService channelService;

    @RequestMapping(path = "add", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Channel addUser(@RequestBody Channel channel) {
        Channel res = channelService.addChannel(channel);
        return res;
    }

    @RequestMapping(path = "remove", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean removeChannel(@RequestBody Channel channel) {
        channelService.removeChannel(channel);
        return true;
    }

}