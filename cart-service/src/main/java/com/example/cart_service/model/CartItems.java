package com.example.cart_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String productName;
    private String productImage;
    private Double rating;
    private Integer ratingCount;
    private Integer quantity;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
