package org.example.ecommerce.features.product.service;

import org.example.ecommerce.features.product.dto.ProductRequest;
import org.example.ecommerce.features.product.dto.ProductResponse;
import org.example.ecommerce.features.product.dto.ProductUpdateRequest;
import org.example.ecommerce.features.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void createProduct(ProductRequest product);
    ProductResponse getProduct(Long id);
    List<ProductResponse> listProducts();
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
