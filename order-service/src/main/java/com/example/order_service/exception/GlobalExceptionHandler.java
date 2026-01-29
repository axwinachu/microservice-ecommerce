package com.example.order_service.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CartIsEmpty.class)
    public Response handleCartEmpty(Exception ex){
        return new Response("404","cart is empty");
    }
    @ExceptionHandler(CartNotFoundException.class)
    public Response handleCartNotFound(Exception ex){
        return new Response("404",ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Response otherException(Exception ex){
        return new Response("500",ex.getMessage());
    }

}
