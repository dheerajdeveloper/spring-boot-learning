package com.notification.controller;

import com.notification.model.DownloadLogs;
import com.notification.model.Greeting;
import com.notification.repository.DownloadLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dheeraj on 20/08/17.
 */


@RequestMapping("downloadlog")
@Controller
public class DownloadLogController {

    @Autowired
    DownloadLogRepository downloadLogRepository;


    //    @RequestMapping(path = "get",
//            method = RequestMethod.GET,
////            consumes = {MediaType.APPLICATION_JSON_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE})
    @GetMapping("get")
    public String getDownloadLog(@RequestParam("id") String id, Model model) {
//        DownloadLogs downloadLog = downloadLogRepository.findFirstByDownloadId(id);

        List<DownloadLogs> downloadLogs = downloadLogRepository.findAllByDownloadId(id);

        model.addAttribute("downloadLogs", downloadLogs);
        return "downloadlog";
    }
}
