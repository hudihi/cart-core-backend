package org.example.ecommerce.features.product.repository;

import org.example.ecommerce.features.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
