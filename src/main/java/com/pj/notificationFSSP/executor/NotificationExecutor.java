package com.pj.notificationFSSP.executor;

import com.pj.notificationFSSP.gatewayImpl.InternalProviderGatewayImpl;
import com.pj.notificationFSSP.gatewayImpl.TwilioGatewayImpl;
import com.pj.notificationFSSP.interfaces.INotificationGatewayFactory;
import com.pj.notificationFSSP.interfaces.INotificationStrategy;
import com.pj.notificationFSSP.dto.NotificationRequestDTO;
import com.pj.notificationFSSP.locator.ServiceLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Get the strategy - way to send notification

@Component
public class NotificationExecutor {

    @Autowired
    private ServiceLocator serviceLocator;

    public NotificationResponseDTO processNotification(NotificationRequestDTO notificationRequestDTO) {
        String beanName = notificationRequestDTO.getChannel().name().toLowerCase() + "NotificationStrategyImpl";
        // get the gateway
        INotificationGatewayFactory notificationGatewayFactory =
                switch (notificationRequestDTO.getChannel()) {
            case SMS, Whatsapp -> new TwilioGatewayImpl();
            case Email -> new InternalProviderGatewayImpl();
        };
        INotificationStrategy notificationStrategy = serviceLocator.getStrategy(beanName);
        return notificationStrategy.notify(notificationRequestDTO, notificationGatewayFactory);
    }

}
