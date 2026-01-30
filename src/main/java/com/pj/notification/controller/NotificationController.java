package com.pj.notification.controller;


import com.pj.notification.dto.NotificationRequestDTO;
import com.pj.notification.executor.NotificationStrategyExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @Autowired
    NotificationStrategyExecutor notificationStrategyExecutor;

    @PostMapping(value = "v1/process", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> notify(@RequestBody NotificationRequestDTO notificationRequestDTO) {
        return notificationStrategyExecutor.sendNotification(notificationRequestDTO);
    }

}
