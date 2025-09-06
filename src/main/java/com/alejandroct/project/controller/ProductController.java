package com.alejandroct.project.controller;

import com.alejandroct.project.model.dto.ProductDto;
import com.alejandroct.project.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> listProducts(){
        return ResponseEntity.ok(this.productService.listProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){
        return new ResponseEntity(this.productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id,
                                                 @Valid @RequestBody ProductDto productDto){

        return ResponseEntity.ok(this.productService.updateProduct(id, productDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductDto> partialUpdateProduct(@PathVariable("id") Long id,
                                                           @Valid @RequestBody ProductDto productDto){

        return  ResponseEntity.ok(this.productService.partialUpdate(id, productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        this.productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
