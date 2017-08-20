package com.notification.repository;

import com.notification.model.Item;
import com.notification.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by dheeraj on 15/08/17.
 */

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long>{
}
