package com.notification.repository;

import com.notification.model.DownloadLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by dheeraj on 20/08/17.
 */

@RepositoryRestResource
public interface DownloadLogRepository extends JpaRepository<DownloadLogs, Long> {

    List<DownloadLogs> findAllByDownloadId(@Param("downloadId") String downloadId);

    DownloadLogs findFirstByDownloadId(@Param("downloadId") String downloadId);
}
