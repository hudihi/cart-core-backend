package org.example.ecommerce.features.product.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.features.product.dto.ProductRequest;
import org.example.ecommerce.features.product.dto.ProductResponse;
import org.example.ecommerce.features.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.ACCEPTED;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> listProducts(){
        List<ProductResponse> response = productService.listProducts();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    @ResponseStatus(ACCEPTED)
    public ResponseEntity<?> addProduct(@RequestBody @Valid ProductRequest request){

    }
}
