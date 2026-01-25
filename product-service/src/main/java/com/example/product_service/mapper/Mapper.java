package com.example.product_service.mapper;

import com.example.product_service.dto.ProductRequestDto;
import com.example.product_service.dto.ProductResponseDto;
import com.example.product_service.model.Product;
import com.example.product_service.model.enums.Availability;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Mapper {
    public ProductResponseDto productToProductResponseDto(Product product){
        return ProductResponseDto.builder().productId(product.getProductId())
                .productName(product.getProductName())
                .shortDescription(product.getShortDescription())
                .description(product.getShortDescription())
                .brand(product.getBrand())
                .price(product.getPrice())
                .discountPrize(product.getDiscountPrize())
                .stockQuantity(product.getStockQuantity())
                .availability(product.getAvailability())
                .mainImageUrl(product.getMainImageUrl())
                .imageUrl(product.getImageUrl())
                .averageRating(product.getAverageRating())
                .reviewCount(product.getReviewCount()).build();

    }
}
