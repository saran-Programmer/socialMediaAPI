package com.InstagramApi.InstagramAPI.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ResponseModel {
    @Getter @Setter
    private String message;
    @Getter @Setter
    private LocalDateTime timeStamp;
    @Getter @Setter
    private HttpStatus statusCode;

    public ResponseModel(){}

    public ResponseModel(String message, HttpStatus statusCode){
        this.message = message;
        this.timeStamp = LocalDateTime.now();
        this.statusCode = statusCode;
    }
}
