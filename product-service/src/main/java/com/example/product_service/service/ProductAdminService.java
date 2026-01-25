package com.example.product_service.service;

import com.example.product_service.exception.ProductIdNotFound;
import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductAdminService {
    private  final ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ProductIdNotFound("id:"+id));
    }

    public Product updateProductById(Product updatedProduct) {
        return productRepository.save(updatedProduct);
    }

    public boolean productFindByNameAndBrand(String productName, String brand) {
         return productRepository.existsByProductNameAndBrand(productName,brand);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
