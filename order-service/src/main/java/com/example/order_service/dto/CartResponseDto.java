package com.example.order_service.dto;

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
    @Builder.Default
    private List<CartItemsResponseDto> items=new ArrayList<>();
    private BigDecimal totalPrice;
}
