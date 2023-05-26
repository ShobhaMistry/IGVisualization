package com.argusoft.who.igvisualization.utils;

import org.springframework.http.HttpStatus;

public class Response<T> {
private HttpStatus status;
private String message;
private T data;

    public HttpStatus getStatus() {
        return status;
    }

    public Response(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Response(T data) {
        this.data = data;
    }
}
