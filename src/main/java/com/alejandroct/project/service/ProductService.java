package com.alejandroct.project.service;

import com.alejandroct.project.model.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> listProducts();

    ProductDto getProductById(Long id);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto productDto);

    ProductDto partialUpdate(Long id, ProductDto productDto);

    void deleteProduct(Long id);

}
