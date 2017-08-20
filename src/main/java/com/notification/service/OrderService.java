package com.notification.service;

import com.notification.json.OrderJson;
import com.notification.json.ProductJson;
import com.notification.model.Channel;
import com.notification.model.Customer;
import com.notification.model.Order;
import com.notification.model.Product;
import com.notification.repository.CustomerRepository;
import com.notification.repository.OrderRepository;
import com.notification.repository.ProductRepository;
import com.notification.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dheeraj on 17/08/17.
 */

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public Order addOrder(OrderJson orderJson) {


        List<ProductJson> productJsonList = orderJson.getProducts();


        StringBuilder stringBuilder = new StringBuilder("");


        for (ProductJson productJson : productJsonList) {


            Product product = new Product();

            product.setName(productJson.getName());
            product.setPrice(Double.parseDouble(productJson.getPrice()));
            product.setProductId(productJson.getProductId());
            product.setTagname(getTagsAsString(productJson.getTags()));
            product.setProductQuantity(Integer.parseInt(productJson.getQty()));

            product.setCustomerId(orderJson.getCustomerId());
            Product savedProduct = productRepository.save(product);

            if(savedProduct != null){
                stringBuilder.append(savedProduct.getId()).append(",");
            }

        }
        Order order = new Order();


        order.setOrderId(orderJson.getOrderId());
        order.setAddress(orderJson.getAddress());
        order.setCustomerId(orderJson.getCustomerId());
        order.setTimestamp(orderJson.getTimestamp());
        order.setProductId(stringBuilder.toString());
//        return orderRepository.save(order);

        return order;

    }

    private String getTagsAsString(List<String> tags) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (String tag : tags) {
            stringBuilder.append(tag).append(",");
        }

        return stringBuilder.toString();
    }
}
