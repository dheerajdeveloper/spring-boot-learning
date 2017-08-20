package com.notification.repository;

import com.notification.model.Order;
import com.notification.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by dheeraj on 15/08/17.
 */

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Long>{

    List<Product> findAllByCustomerId(String customerId);

}
