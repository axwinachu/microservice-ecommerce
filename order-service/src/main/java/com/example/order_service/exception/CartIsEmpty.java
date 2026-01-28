package com.example.order_service.exception;

public class CartIsEmpty extends RuntimeException {
    public CartIsEmpty(String message) {
        super(message);
    }
}
