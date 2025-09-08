package com.alejandroct.project.service.impl;

import com.alejandroct.project.exception.ProductNotFoundException;
import com.alejandroct.project.mapper.Mapper;
import com.alejandroct.project.mapper.impl.ProductMapper;
import com.alejandroct.project.model.dto.ProductDto;
import com.alejandroct.project.model.entity.Product;
import com.alejandroct.project.repository.ProductRepository;
import com.alejandroct.project.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final Mapper<Product, ProductDto> productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> listProducts() {
        return this.productRepository.findAll()
                .stream().map(productMapper::toDto).toList();
    }

    @Override
    public ProductDto getProductById(Long id) {
        return this.productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = this.productMapper.toEntity(productDto);
        product.setId(null);
        return this.productMapper.toDto(this.productRepository.save(product));
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = this.findProductById(id).orElseThrow(ProductNotFoundException::new);
        product.setName(productDto.name());
        product.setDescription(productDto.description());
        product.setPrice(productDto.price());

        return this.productMapper.toDto(this.productRepository.save(product));
    }

    @Override
    public ProductDto partialUpdate(Long id, ProductDto productDto) {
        Product product = this.findProductById(id).orElseThrow(ProductNotFoundException::new);
        Optional.ofNullable(productDto.name()).ifPresent(product::setName);
        Optional.ofNullable(productDto.description()).ifPresent(product::setDescription);
        Optional.ofNullable(productDto.price()).ifPresent(product::setPrice);
        return this.productMapper.toDto(this.productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        this.findProductById(id).orElseThrow(ProductNotFoundException::new);
        this.productRepository.deleteById(id);
    }

    private Optional<Product> findProductById(Long id){
        return this.productRepository.findById(id);
    }
}
