package com.pj.notification.executor;

import com.pj.notification.dto.NotificationRequestDTO;
import com.pj.notification.strategy.INotificationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * this class helps you find the strategy instance based on channel name
 */
@Component
public class NotificationStrategyExecutor {

//    Autowiring needed to get all the instances of the beans/classes that implements the INotificationStrategy interface
    @Autowired
    private Map<String, INotificationStrategy> notificationStrategiesList;

    public ResponseEntity<?> sendNotification(NotificationRequestDTO notificationRequestDTO) {
//      the instance based on channel shared by user get selected, channel is basically an alternative name that we gave to the class that implements the interface
        INotificationStrategy notificationStrategy = notificationStrategiesList.get(notificationRequestDTO.getChannel().name());
        return new ResponseEntity<>(notificationStrategy.send(notificationRequestDTO.getMessage()), HttpStatus.OK);
    }
}
