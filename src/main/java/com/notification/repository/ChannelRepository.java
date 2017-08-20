package com.notification.repository;

import com.notification.enums.NotificationChannel;
import com.notification.model.Channel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by dheeraj on 15/08/17.
 */

@RepositoryRestResource
public interface ChannelRepository extends CrudRepository<Channel, Long>{

    List<Channel> findAllByUserId(long userId);

    Channel findByUserIdAndChannel(long userId, NotificationChannel channel);
}
