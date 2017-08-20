package com.notification.controller;

import com.notification.model.Greeting;
import com.notification.model.User;
import com.notification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GreetingController {


    @Autowired
    UserService userService;


//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
//
//        List<User> users = (List<User>) userService.getAllUsers();
//
//        model.addAttribute("users", users);
//        return "greeting";
//    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }

}
