package com.notification.service;

import com.notification.model.Item;
import com.notification.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dheeraj on 15/08/17.
 */

@Service
public class ItemService {


    @Autowired
    ItemRepository itemRepository;


    public Item addPackage(Item item) {
        Item data = itemRepository.save(item);
        return data;
    }
}
