package com.pj.notificationFSSP.locator;

import com.pj.notificationFSSP.interfaces.INotificationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ServiceLocator {

    @Autowired
    private ApplicationContext applicationContext;

    public INotificationStrategy getStrategy(String beanName) {
        return applicationContext.getBean(beanName, INotificationStrategy.class);
    }
}
