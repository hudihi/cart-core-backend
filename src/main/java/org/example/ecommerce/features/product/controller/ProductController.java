package org.example.ecommerce.features.product.controller;


import org.example.ecommerce.features.product.dto.ProductResponse;
import org.example.ecommerce.features.product.model.Product;
import org.example.ecommerce.features.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> listProducts(){
        List<ProductResponse> response = productService.listProducts();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
