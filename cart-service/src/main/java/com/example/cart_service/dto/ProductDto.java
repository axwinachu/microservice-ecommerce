package com.example.cart_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long productId;
    private String productName;
    private String shortDescription;
    private String description;
    private String brand;
    private String category;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Integer stockQuantity;
    private String mainImageUrl;
    private List<String> imageUrls;
    private Double averageRating;
    private Integer reviewCount;
}
