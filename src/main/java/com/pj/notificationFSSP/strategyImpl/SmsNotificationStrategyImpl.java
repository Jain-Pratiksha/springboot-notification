package com.pj.notificationFSSP.strategyImpl;

import com.pj.notificationFSSP.interfaces.INotificationGatewayFactory;
import com.pj.notificationFSSP.interfaces.INotificationStrategy;
import com.pj.notificationFSSP.dto.NotificationRequestDTO;
import com.pj.notificationFSSP.executor.NotificationResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationStrategyImpl implements INotificationStrategy {

    @Override
    public NotificationResponseDTO notify(NotificationRequestDTO notificationRequestDTO, INotificationGatewayFactory notificationGatewayFactory) {
        return new NotificationResponseDTO(notificationGatewayFactory.sendNotification(notificationRequestDTO), "Message sent via SMS");
    }

}
