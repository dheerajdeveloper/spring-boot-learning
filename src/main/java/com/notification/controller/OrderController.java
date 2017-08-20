package com.notification.controller;

import com.notification.json.OrderJson;
import com.notification.model.Channel;
import com.notification.model.Order;
import com.notification.service.ChannelService;
import com.notification.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(path = "add", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Order addUser(@RequestBody OrderJson orderJson) {
        Order res = orderService.addOrder(orderJson);
        return res;
    }

}