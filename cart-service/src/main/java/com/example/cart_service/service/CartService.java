package com.example.cart_service.service;

import com.example.cart_service.model.Cart;
import com.example.cart_service.repository.CartRepository;
import jakarta.websocket.server.ServerEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    public Optional<Cart> findByUserId(Long userId){
        return cartRepository.findByUserId(userId);
    }
    public Cart createCart(Long userId){
        Cart cart=Cart.builder()
                .userId(userId)
                .totalPrice(BigDecimal.ZERO)
                .build();
        return cartRepository.save(cart);

    }
    public Cart save(Cart cart){
        return cartRepository.save(cart);
    }
}
