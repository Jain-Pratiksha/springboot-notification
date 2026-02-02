package com.pj.notificationFSSP.interfaces;

import com.pj.notificationFSSP.dto.NotificationRequestDTO;
import com.pj.notificationFSSP.executor.NotificationResponseDTO;

public interface INotificationStrategy {

    NotificationResponseDTO notify(NotificationRequestDTO notificationRequestDTO, INotificationGatewayFactory notificationGatewayFactory);

}
