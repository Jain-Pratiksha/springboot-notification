package com.pj.notification.dto;

import com.pj.notification.utils.Enums;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationRequestDTO {

    private Enums.channelTypes channel;

    @NotNull
    private String message;
}
