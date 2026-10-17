package org.example.ecommerce.features.category.repository;

import org.example.ecommerce.features.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
