package com.notification.controller;

import com.notification.model.Item;
import com.notification.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("item")
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(path = "add", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Item addUser(@RequestBody Item item) {
        Item itemId = itemService.addPackage(item);
        return itemId;
    }

}