package com.example.product_service.service;

import com.example.product_service.dto.ProductResponseDto;
import com.example.product_service.exception.ProductIdNotFound;
import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductPublicService {
    private final ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ProductIdNotFound("id"+id));
    }

    public List<Product> getProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getProductBySearch(String search) {
        return productRepository.findByProductNameContainingIgnoreCase(search);
    }
}
