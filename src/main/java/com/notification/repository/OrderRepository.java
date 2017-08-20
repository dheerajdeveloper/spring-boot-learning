package com.notification.repository;

import com.notification.enums.NotificationChannel;
import com.notification.model.Channel;
import com.notification.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by dheeraj on 15/08/17.
 */

@RepositoryRestResource
public interface OrderRepository extends CrudRepository<Order, Long>{

}
