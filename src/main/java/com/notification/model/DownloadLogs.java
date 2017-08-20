package com.notification.model;

import lombok.Data;
import org.springframework.cglib.core.GeneratorStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by dheeraj on 20/08/17.
 */


@Entity
@Data
public class DownloadLogs implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String downloadId;

    String requestSource;

    String status;

    String createdOn;

    String updatedOn;

    String columnRequested;

    String requestType;

    String requestToNotiReceiveTime;

    String notiReceivedToNotiSentTime;

    String errorCode;

    String request;





}
