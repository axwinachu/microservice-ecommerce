package com.example.order_service.client;

import com.example.order_service.dto.CartResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "cart-service")
public interface CartClient {
    @GetMapping("api/cart")
    public CartResponseDto getCart(@RequestHeader("X_USER_ID") Long userId);

    @DeleteMapping("/api/cart")
    void clearCart(@RequestHeader("X-USER-ID") Long userId);
}
