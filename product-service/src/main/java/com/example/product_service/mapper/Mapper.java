package com.example.product_service.mapper;

import com.example.product_service.dto.ProductRequestDto;
import com.example.product_service.dto.ProductResponseDto;
import com.example.product_service.model.Product;
import com.example.product_service.service.ProductAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@RequiredArgsConstructor
public class Mapper {
    public ProductResponseDto productToProductResponseDto(Product product){
        return ProductResponseDto.builder().productId(product.getProductId())
                .productName(product.getProductName())
                .shortDescription(product.getShortDescription())
                .description(product.getDescription())
                .brand(product.getBrand())
                .category(product.getCategory())
                .price(product.getPrice())
                .discountPrice(product.getDiscountPrice())
                .stockQuantity(product.getStockQuantity())
                .availability(product.getAvailability())
                .mainImageUrl(product.getMainImageUrl())
                .imageUrls(product.getImageUrl())
                .averageRating(product.getAverageRating())
                .reviewCount(product.getReviewCount()).build();

    }
    public ProductRequestDto productToProductRequestDto(Product product){
        return ProductRequestDto.builder().productId(product.getProductId())
                .productName(product.getProductName())
                .shortDescription(product.getShortDescription())
                .description(product.getDescription())
                .category(product.getCategory())
                .brand(product.getBrand())
                .price(product.getPrice())
                .discountPrice(product.getDiscountPrice())
                .taxPercentage(product.getTaxPercentage())
                .stockQuantity(product.getStockQuantity())
                .availability(product.getAvailability())
                .mainImageUrl(product.getMainImageUrl())
                .imageUrl(product.getImageUrl())
                .reviewCount(product.getReviewCount())
                .build();
    }
    public Product productRequestDtoToProduct(ProductRequestDto productRequestDto){
        return Product.builder()
                .productName(productRequestDto.getProductName())
                .shortDescription(productRequestDto.getShortDescription())
                .description(productRequestDto.getDescription())
                .category(productRequestDto.getCategory())
                .brand(productRequestDto.getBrand())
                .price(productRequestDto.getPrice())
                .discountPrice(productRequestDto.getDiscountPrice())
                .taxPercentage(productRequestDto.getTaxPercentage())
                .stockQuantity(productRequestDto.getStockQuantity())
                .availability(productRequestDto.getAvailability())
                .mainImageUrl(productRequestDto.getMainImageUrl())
                .imageUrl(productRequestDto.getImageUrl())
                .averageRating(productRequestDto.getAverageRating())
                .reviewCount(productRequestDto.getReviewCount())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
