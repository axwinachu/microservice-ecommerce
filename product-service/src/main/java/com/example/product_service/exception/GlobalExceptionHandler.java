package com.example.product_service.exception;

import com.example.product_service.exception.Responses.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductIdNotFound.class)
    public Response handleProductIdNotFound(Exception ex){
        return new Response("404","product" +ex.getMessage()+"not found");
    }
}
