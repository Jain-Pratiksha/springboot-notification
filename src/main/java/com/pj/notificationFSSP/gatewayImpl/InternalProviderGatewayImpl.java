package com.pj.notificationFSSP.gatewayImpl;

import com.pj.notificationFSSP.dto.NotificationRequestDTO;
import com.pj.notificationFSSP.executor.NotificationResponseDTO;
import com.pj.notificationFSSP.interfaces.INotificationGatewayFactory;
import org.springframework.stereotype.Component;

@Component
public class InternalProviderGatewayImpl implements INotificationGatewayFactory {

    @Override
    public boolean sendNotification(NotificationRequestDTO notificationRequestDTO) {
        System.out.println("Email Notification sent via Internal Provider");
        return true;
    }

}
