package com.notification.repository;

import com.notification.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by dheeraj on 15/08/17.
 */

@RepositoryRestResource
public interface ItemRepository extends CrudRepository<Item, Long>{

    List<Item> findAllByUserId(long userId);
}
