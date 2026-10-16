package org.example.ecommerce.features.product.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.features.product.dto.ProductRequest;
import org.example.ecommerce.features.product.dto.ProductResponse;
import org.example.ecommerce.features.product.model.Product;
import org.example.ecommerce.features.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductRequest request){
        productService.createProduct(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{productId}")
    @ResponseStatus(OK)
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("productId") Long productId){
        var product = productService.getProduct(productId);

        return ResponseEntity.ok(product);
    }
}
