package com.pj.notificationFSSP.dto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.pj.notificationFSSP.utils.Enums;

@Data
public class NotificationRequestDTO {

    private Enums.channelType channel;

    @NotNull(message = "message cannot be empty")
    private String message;

}