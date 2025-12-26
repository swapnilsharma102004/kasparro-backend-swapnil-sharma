package com.kasparro.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class HealthStatusRequest {

    @NotBlank(message = "Status cannot be empty")
    @Size(max = 20,message = "Status max length is 20")
    private String status;

    @NotBlank(message = "message cannot be empty")
    @Size(max = 255 , message="message max length is 255")
    private String message;

    public HealthStatusRequest(){

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HealthStatusRequest(String status, String message){
        this.status = status;
        this.message = message;
    }
}
