package com.example.product_service.controller;

import com.example.product_service.dto.ProductResponseDto;
import com.example.product_service.facade.ProductPublicFacade;
import com.example.product_service.service.ProductPublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductPublicController {
    private final ProductPublicFacade productPublicFacade;
    @GetMapping("/products")
    public List<ProductResponseDto> getALlProducts(){
        return productPublicFacade.getAllProducts();
    }
    @GetMapping("/product/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id){
        return productPublicFacade.getProductById(id);
    }
    @GetMapping("/product/{category}")
    public List<ProductResponseDto> getProductByCategory(@PathVariable String category){
        return productPublicFacade.getProductByCategory(category);
    }
    @GetMapping("/product/{search}")
    public List<ProductResponseDto> getProductBySearch(@PathVariable String search){
        return productPublicFacade.getProductBySearch(search);
    }
}
