package com.example.cart_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @OneToMany(
            mappedBy = "cart",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    @Builder.Default
    private List<CartItems> items=new ArrayList<>();
    private BigDecimal totalPrice;
}
