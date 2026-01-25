package com.example.product_service.facade;

import com.example.product_service.dto.ProductRequestDto;
import com.example.product_service.dto.ProductResponseDto;
import com.example.product_service.exception.AlreadyHaveAProduct;
import com.example.product_service.mapper.Mapper;
import com.example.product_service.model.Product;
import com.example.product_service.service.ProductAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductAdminFacade {
    private final ProductAdminService productAdminService;
    private final Mapper mapper;
    public List<ProductRequestDto> getAllProducts() {
        List<Product> products=productAdminService.getAllProducts();
        return products.stream().map(mapper::productToProductRequestDto).toList();
    }

    public ProductRequestDto getProductById(Long id) {
        Product product=productAdminService.getProductById(id);
        return mapper.productToProductRequestDto(product);
    }

    public ProductRequestDto updateProductById(ProductRequestDto productRequestDto) {
        Product updatedProduct= mapper.productRequestDtoToProduct(productRequestDto);
        return mapper.productToProductRequestDto(productAdminService.updateProductById(updatedProduct));

    }

    public ProductRequestDto addNewProduct(ProductRequestDto productRequestDto) {
        boolean product= productAdminService.productFindByNameAndBrand(productRequestDto.getProductName(),productRequestDto.getBrand());
        if (!product){
            return mapper.productToProductRequestDto(productAdminService.addProduct(mapper.productRequestDtoToProduct(productRequestDto)));
        }
        throw new AlreadyHaveAProduct("name"+productRequestDto.getProductName()+"brand"+productRequestDto.getProductName());

    }

    public ProductRequestDto deleteById(Long id) {
        ProductRequestDto product=mapper.productToProductRequestDto(productAdminService.getProductById(id));
        productAdminService.deleteProductById(id);
        return product ;
    }
}
