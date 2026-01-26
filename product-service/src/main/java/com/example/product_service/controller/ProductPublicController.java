package com.example.product_service.controller;

import com.example.product_service.dto.ProductResponseDto;
import com.example.product_service.facade.ProductPublicFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/products/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id){
        return productPublicFacade.getProductById(id);
    }
    @GetMapping("/products/category/{category}")
    public List<ProductResponseDto> getProductByCategory(@PathVariable String category){
        return productPublicFacade.getProductByCategory(category);
    }
    @GetMapping("/products/search")
    public List<ProductResponseDto> getProductBySearch(@RequestParam String search){
        return productPublicFacade.getProductBySearch(search);
    }
}
