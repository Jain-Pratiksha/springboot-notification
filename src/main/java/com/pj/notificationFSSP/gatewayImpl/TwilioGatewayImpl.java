package com.pj.notificationFSSP.gatewayImpl;

import com.pj.notificationFSSP.dto.NotificationRequestDTO;
import com.pj.notificationFSSP.executor.NotificationResponseDTO;
import com.pj.notificationFSSP.interfaces.INotificationGatewayFactory;
import com.pj.notificationFSSP.utils.Enums;
import org.springframework.stereotype.Component;

@Component
public class TwilioGatewayImpl implements INotificationGatewayFactory {

    @Override
    public boolean sendNotification(NotificationRequestDTO notificationRequestDTO) {
        if (notificationRequestDTO.getChannel().equals(Enums.channelType.SMS)) {
            System.out.println("SMS Notification sent via Twilio");
            return true;
        } else {
            System.out.println("Whatsapp Notification sent via Twilio");
            return true;
        }
    }

}
