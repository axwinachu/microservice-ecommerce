package com.example.cart_service.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CartNotFoundException.class)
    public Response handleCartNotFoundException(Exception ex){
        return new Response(ex.getMessage());
    }
    @ExceptionHandler(OutofStockException.class)
    public Response handleOutOfStockException(Exception ex){
        return  new Response(ex.getMessage());
    }
    @ExceptionHandler(ProducIdNotFoundException.class)
    public Response handleProductIdNotFound(Exception ex){
        return new Response(ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Response handleOtherExceptions(Exception ex){
        return new Response(ex.getMessage());
    }
}
