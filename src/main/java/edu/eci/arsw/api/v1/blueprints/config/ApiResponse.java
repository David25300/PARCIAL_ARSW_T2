package edu.eci.arsw.api.v1.blueprints.config;

import org.springframework.http.ResponseEntity;

public record ApiResponse<T>(int code, String message, T data) {
    public String message(){

        return message();
    }
}