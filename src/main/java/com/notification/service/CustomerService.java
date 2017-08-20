package com.notification.service;

import com.notification.model.Product;
import com.notification.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dheeraj on 17/08/17.
 */

@Service
public class CustomerService {

    @Autowired
    ProductRepository productRepository;

    public Map<String, Double> getCustomer(String customerId) {

        List<Product> productList = productRepository.findAllByCustomerId(customerId);

        Map<String, Double> map = new HashMap<String, Double>();

        for (Product product : productList) {

            String tags[] = product.getTagname().split(",");

            for (String tag : tags) {
                if (!map.containsKey(tag)) {
                    map.put(tag, 0.0);
                }

                map.put(tag, map.get(tag) + product.getPrice());
            }
        }

        return map;


    }
}
