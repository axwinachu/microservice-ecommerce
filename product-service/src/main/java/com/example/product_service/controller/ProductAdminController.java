package com.example.product_service.controller;

import com.example.product_service.dto.ProductRequestDto;
import com.example.product_service.facade.ProductAdminFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/products")
public class ProductAdminController {
    private final ProductAdminFacade productAdminFacade;
    @GetMapping
    public List<ProductRequestDto> getAllProducts(){
        return productAdminFacade.getAllProducts();
    }
    @GetMapping("/{id}")
    public ProductRequestDto getProductsById(@PathVariable Long id){
        return productAdminFacade.getProductById(id);
    }
    @PostMapping
    public ProductRequestDto addNewProduct(@RequestBody ProductRequestDto productRequestDto){
        return productAdminFacade.addNewProduct(productRequestDto);
    }
    @PutMapping
    public ProductRequestDto updateProductById(@RequestBody ProductRequestDto productRequestDto){
        return productAdminFacade.updateProductById(productRequestDto);
    }
    @DeleteMapping("/{id}")
    public ProductRequestDto deleteProductById(@PathVariable Long id){
        return productAdminFacade.deleteById(id);
    }

}
