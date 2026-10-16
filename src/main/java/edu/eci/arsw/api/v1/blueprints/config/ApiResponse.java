package edu.eci.arsw.api.v1.blueprints.config;


public record ApiResponse<T>(int code, String message, T data) {

}