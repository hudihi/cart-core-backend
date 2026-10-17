package org.example.ecommerce.features.product.service;

import org.example.ecommerce.features.product.dto.ProductRequest;
import org.example.ecommerce.features.product.dto.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    /**
    * Creates a new product based on validated incoming payload
    */
    ProductResponse createProduct(ProductRequest product);

    /**
    * Retrieves a single product by its unique identifier
    */
    ProductResponse getProduct(Long id);


    /**
    * Retrieves a paginated and sorted list of products for catalog browsing.
    */
    Page<ProductResponse> listProducts(Pageable pageable);

    /**
    * Updates an existing product using a request DTO, returning the updated view
    */
    ProductResponse updateProduct(Long id, ProductRequest request);

    /**
    * Soft-delete or safely removes a product by its ID
    */
    void deleteProduct(Long id);
}
