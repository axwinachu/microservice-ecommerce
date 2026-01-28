package com.example.cart_service.dto;

import com.example.cart_service.model.CartItems;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponseDto {
    private Long id;
    private Long userId;
    private List<CartItemsResponseDto> items=new ArrayList<>();
    private BigDecimal totalPrice;
}
