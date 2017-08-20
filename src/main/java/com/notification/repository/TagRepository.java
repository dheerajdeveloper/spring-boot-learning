package com.notification.repository;

import com.notification.model.Order;
import com.notification.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by dheeraj on 15/08/17.
 */

@RepositoryRestResource
public interface TagRepository extends CrudRepository<Tag, Long>{

}
