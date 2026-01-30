package com.example.cart_service.client;

import com.example.cart_service.dto.ProductDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ProductServiceClient {

    private final ProductClient productClient;

    @CircuitBreaker(name = "productService", fallbackMethod = "productFallback")
    @Retry(name = "productService")
    @TimeLimiter(name = "productService")
    public CompletableFuture<ProductDto> getProduct(Long productId) {
        return CompletableFuture.supplyAsync(() ->
                productClient.getProduct(productId)
        );
    }
    public CompletableFuture<ProductDto> productFallback(
            Long productId, Throwable ex) {

        return CompletableFuture.completedFuture(
                ProductDto.builder()
                        .productId(productId)
                        .productName("Product service unavailable")
                        .price(BigDecimal.ZERO)
                        .stockQuantity(0)
                        .build()
        );
    }
}

