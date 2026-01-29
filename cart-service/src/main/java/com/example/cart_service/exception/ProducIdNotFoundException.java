package com.example.cart_service.exception;

public class ProducIdNotFoundException extends RuntimeException {
    public ProducIdNotFoundException(String message) {
        super(message);
    }
}
