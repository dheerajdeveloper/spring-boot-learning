package com.notification.controller;

import com.notification.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(path = "get/{id}",
            method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Double> getUser(@PathVariable("id") String customerId) {
        Map<String, Double> data = customerService.getCustomer(customerId);
        return data;
    }

}