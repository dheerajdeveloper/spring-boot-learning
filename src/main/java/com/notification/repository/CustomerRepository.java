package com.notification.repository;

import com.notification.model.Customer;
import com.notification.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by dheeraj on 15/08/17.
 */

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
