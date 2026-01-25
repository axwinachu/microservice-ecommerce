package com.example.product_service.facade;

import com.example.product_service.dto.ProductResponseDto;
import com.example.product_service.mapper.Mapper;
import com.example.product_service.model.Product;
import com.example.product_service.service.ProductPublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductPublicFacade {
    private final Mapper mapper;
    private final ProductPublicService productPublicService;
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products=productPublicService.getAllProducts();
        return products.stream().map(mapper::productToProductResponseDto).toList();
    }

    public ProductResponseDto getProductById(Long id) {
        Product product=productPublicService.getProductById(id);
        return mapper.productToProductResponseDto(product);
    }

    public List<ProductResponseDto> getProductByCategory(String category) {
        List<Product> products=productPublicService.getProductByCategory(category);
        return products.stream().map(mapper::productToProductResponseDto).toList();
    }

    public List<ProductResponseDto> getProductBySearch(String search) {
        List<Product> products=productPublicService.getProductBySearch(search);
        return products.stream().map(mapper::productToProductResponseDto).toList();
    }
}
