package org.example.ecommerce.features.product.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.features.image.service.ProductImageService;
import org.example.ecommerce.features.product.dto.ProductRequest;
import org.example.ecommerce.features.product.dto.ProductResponse;
import org.example.ecommerce.features.product.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductImageService productImageService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request){
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity.status(CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id){
        ProductResponse response = productService.getProduct(id);
        return ResponseEntity.status(OK).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ProductResponse>> listProducts(
            @PageableDefault(size = 20, sort = "id") Pageable pageable
    ){
        Page<ProductResponse> response = productService.listProducts(pageable);
        return ResponseEntity.status(OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request
    ){
        ProductResponse response = productService.updateProduct(id, request);
        return ResponseEntity.status(OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{productId}/images")
    public ResponseEntity<ProductResponse> uploadImage(
            @PathVariable Long productId,
            @RequestParam("file")MultipartFile file,
            @RequestParam(value = "isPrimary", defaultValue = "false") boolean isPrimary
            ){
        ProductResponse response = productImageService.uploadAndAddImageToProduct(productId, file, isPrimary);
        return ResponseEntity.status(CREATED).body(response);
    }

}
