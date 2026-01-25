package com.example.product_service.dto;

import com.example.product_service.model.enums.Availability;
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
public class ProductResponseDto {
    private Long productId;
    private String productName;
    private String shortDescription;
    private String description;
    private String brand;
    private String category;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Integer stockQuantity;
    private Availability availability;
    private String mainImageUrl;
    private List<String> imageUrls;
    private Double averageRating;
    private Integer reviewCount;

}
