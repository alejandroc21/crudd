package com.alejandroct.project.model.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private String code;
    private HttpStatus status;
    private String message;
    private List<String> detailMessage;
    private LocalDateTime timeStamp;

    public ErrorResponse(){}

    public ErrorResponse(String code,
                         HttpStatus status,
                         String message,
                         List<String> detailMessage,
                         LocalDateTime timeStamp) {

        this.code = code;
        this.status = status;
        this.message = message;
        this.detailMessage = detailMessage;
        this.timeStamp = timeStamp;
    }

    public static class Builder{
        private String code;
        private HttpStatus status;
        private String message;
        private List<String> detailMessage;
        private LocalDateTime timeStamp;

        public Builder code(String code){
            this.code = code;
            return this;
        }

        public Builder status(HttpStatus status){
            this.status = status;
            return this;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public Builder detailMessage(List<String> detailMessage){
            this.detailMessage = detailMessage;
            return this;
        }

        public Builder timeStamp(LocalDateTime timeStamp){
            this.timeStamp = timeStamp;
            return this;
        }

        public ErrorResponse build(){
            return new ErrorResponse(
                    this.code,
                    this.status,
                    this.message,
                    this.detailMessage,
                    this.timeStamp
            );
        }


    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetailMessage() {
        return detailMessage;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
