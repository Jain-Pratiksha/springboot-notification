package com.pj.notificationFSSP.interfaces;

import com.pj.notificationFSSP.dto.NotificationRequestDTO;

public interface INotificationGatewayFactory {

    boolean sendNotification(NotificationRequestDTO notificationRequestDTO);

}
