package com.example.product_service.dto;

import com.example.product_service.model.enums.Availability;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {
    private Long productId;
    private String productName;
    @Column(length = 500)
    private String shortDescription;
    @Column(length=5000)
    private String description;
    private String brand;
    private BigDecimal price;
    private BigDecimal discountPrize;
    private Integer stockQuantity;
    @Enumerated(EnumType.STRING)
    private Availability availability;
    private String mainImageUrl;
    @ElementCollection
    private List<String> imageUrl;
    private Double averageRating;
    private Integer reviewCount;

}
