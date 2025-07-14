package com.techYash_bit.BankingSystem.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private ApiError Error;

    private LocalDateTime timeStamp;
    private T data;

    public ApiResponse(){
        this.timeStamp=LocalDateTime.now();
    }
    public ApiResponse(T data) {
        this();
        this.data = data;
    }
    public ApiResponse(ApiError apiError) {
        this();
        this.Error = apiError;
    }
}
