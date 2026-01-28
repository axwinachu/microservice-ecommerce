package com.example.order_service.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CartIsEmpty.class)
    public Response handleCartEmpty(Exception ex){
        return new Response("404","cart is empty");
    }

}
