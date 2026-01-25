package com.example.product_service.exception;

public class AlreadyHaveAProduct extends RuntimeException {
    public AlreadyHaveAProduct(String message) {
        super(message);
    }
}
