package com.pj.notification.strategyImpl.channels;

import com.pj.notification.strategy.INotificationStrategy;
import org.springframework.stereotype.Component;

@Component("WhatsApp")
public class WhatsAppNotificationStrategyImpl implements INotificationStrategy {

//    Override annotation helps to validate functions as per in interface
    @Override
    public String send(String message) {
        return "Notification sent via WhatsApp: " + message;
    }

}
