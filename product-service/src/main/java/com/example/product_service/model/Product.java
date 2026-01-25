package com.example.product_service.model;

import com.example.product_service.model.enums.Availability;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    @Column(length = 500)
    private String shortDescription;
    @Column(length=5000)
    private String description;
    private String brand;
    private BigDecimal price;
    private BigDecimal discountPrize;
    private Double taxPercentage;
    private Integer stockQuantity;
    @Enumerated(EnumType.STRING)
    private Availability availability;
    private String mainImageUrl;
    @ElementCollection
    private List<String> imageUrl;
    private Double averageRating;
    private Integer reviewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
