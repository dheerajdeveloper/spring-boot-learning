package com.notification.controller;

import com.notification.model.*;
import com.notification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(path = "add",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public User addUser(@RequestBody User user) {
        User data = userService.addUser(user);
        return data;
    }


//    @RequestMapping(path = "save",
//            method = RequestMethod.POST,
//            consumes = {MediaType.APPLICATION_JSON_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    public User saveUser(@ModelAttribute User user, BindingResult bindingResult, Model model) {
//        User data = userService.addUser(user);
//        return data;
//    }




    @RequestMapping(path = "getall",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Iterable<User> getUser() {
        Iterable<User> data = userService.getAllUsers();
        return data;
    }

    @RequestMapping(path = "getuser/{id}",
            method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUser(@PathVariable("id") long id) {
        User data = userService.getUser(id);
        return data;
    }

    @RequestMapping(path = "getuseralldetail/{id}",
            method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserAllData getUserAllDetail(@PathVariable("id") long id) {
        UserAllData data = userService.getUserAllData(id);
        return data;
    }



    @RequestMapping(path = "getitemsforuser/{id}",
            method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Item> getitemsforuser(@PathVariable("id") long id) {
        List<Item> data = userService.getItemsForUser(id);
        return data;
    }


    @RequestMapping(path = "getchannelforuser/{id}",
            method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Channel> getchanelforuser(@PathVariable("id") long id) {
        List<Channel> data = userService.getChannelsForUser(id);
        return data;
    }

    @RequestMapping(path = "getnotificationforuser/{id}",
            method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Notification> getnotificationforuser(@PathVariable("id") long id) {
        List<Notification> data = userService.getNotificationsForUser(id);
        return data;
    }

}