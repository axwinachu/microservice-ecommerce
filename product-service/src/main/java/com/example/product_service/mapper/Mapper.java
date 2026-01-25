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
    private final ProductAdminService productAdminService;
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
    public ProductRequestDto productToProductRequestDto(Product product){
        return ProductRequestDto.builder().productId(product.getProductId())
                .productName(product.getProductName())
                .shortDescription(product.getShortDescription())
                .description(product.getDescription())
                .brand(product.getBrand())
                .price(product.getPrice())
                .discountPrize(product.getDiscountPrize())
                .taxPercentage(product.getTaxPercentage())
                .stockQuantity(product.getStockQuantity())
                .availability(product.getAvailability())
                .mainImageUrl(product.getMainImageUrl())
                .imageUrl(product.getImageUrl())
                .reviewCount(product.getReviewCount())
                .build();
    }
    public Product productRequestDtoToProduct(ProductRequestDto productRequestDto){
        Product existingproduct=productAdminService.getProductById(productRequestDto.getProductId());
        return Product.builder()
                .productId(existingproduct.getProductId())
                .productName(productRequestDto.getProductName())
                .shortDescription(productRequestDto.getShortDescription())
                .description(productRequestDto.getDescription())
                .brand(productRequestDto.getBrand())
                .price(productRequestDto.getPrice())
                .price(productRequestDto.getPrice())
                .discountPrize(productRequestDto.getDiscountPrize())
                .taxPercentage(productRequestDto.getTaxPercentage())
                .stockQuantity(productRequestDto.getStockQuantity())
                .availability(productRequestDto.getAvailability())
                .mainImageUrl(productRequestDto.getMainImageUrl())
                .imageUrl(productRequestDto.getImageUrl())
                .averageRating(productRequestDto.getAverageRating())
                .reviewCount(productRequestDto.getReviewCount())
                .createdAt(existingproduct.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
