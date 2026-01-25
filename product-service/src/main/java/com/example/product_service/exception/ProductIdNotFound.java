package com.example.product_service.exception;

public class ProductIdNotFound extends RuntimeException {
    public ProductIdNotFound(String message) {
        super(message);
    }
}
