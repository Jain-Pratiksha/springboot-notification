package com.pj.notificationFSSP.controller;

import com.pj.notificationFSSP.dto.NotificationRequestDTO;
import com.pj.notificationFSSP.executor.NotificationExecutor;
import com.pj.notificationFSSP.executor.NotificationResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify/")
public class NotificationController {

    @Autowired
    NotificationExecutor notificationExecutor;

    @PostMapping(value = "v1/process", consumes = "application/json", produces = "application/json")
    public NotificationResponseDTO sendNotification(@RequestBody NotificationRequestDTO notificationRequestDTO) {
        return notificationExecutor.processNotification(notificationRequestDTO);
    }

}
