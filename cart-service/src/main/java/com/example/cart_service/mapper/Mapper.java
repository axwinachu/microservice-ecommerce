package com.example.cart_service.mapper;

import com.example.cart_service.dto.CartItemsResponseDto;
import com.example.cart_service.dto.CartResponseDto;
import com.example.cart_service.model.Cart;
import com.example.cart_service.model.CartItems;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {
    public CartItemsResponseDto cartItemTOCartItemsResponseDto(CartItems cartItems){
        return CartItemsResponseDto.builder()
                .productId(cartItems.getProductId())
                .productName(cartItems.getProductName())
                .productImage(cartItems.getProductImage())
                .quantity(cartItems.getQuantity())
                .price(cartItems.getPrice())
                .build();
    }
}
