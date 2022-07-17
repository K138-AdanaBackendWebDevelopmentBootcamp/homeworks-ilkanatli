package com.proje.model.api.error;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ApiError {

    private HttpStatus httpStatus;

    private String message;

    private Date date;

    public ApiError(HttpStatus httpStatus, String message, Date date) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.date = date;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}