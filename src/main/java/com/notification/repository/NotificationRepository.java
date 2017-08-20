package com.notification.repository;

import com.notification.model.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by dheeraj on 15/08/17.
 */

@RepositoryRestResource
public interface NotificationRepository extends CrudRepository<Notification , Long>{

    List<Notification> findAllByUserId(long userId);

    Notification findFirstByUserIdAndNotificationType(long userid, String notificationType);
}
