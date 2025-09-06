package com.alejandroct.project.mapper.impl;

import com.alejandroct.project.mapper.Mapper;
import com.alejandroct.project.model.dto.ProductDto;
import com.alejandroct.project.model.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<Product, ProductDto> {

    @Override
    public Product toEntity(ProductDto productDto) {
        return new Product.Builder()
                .id(productDto.id())
                .name(productDto.name())
                .description(productDto.description())
                .price(productDto.price())
                .build();
    }

    @Override
    public ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }
}
