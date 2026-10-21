package org.example.ecommerce.features.category.service;

import org.example.ecommerce.features.category.dto.CategoryRequest;
import org.example.ecommerce.features.category.dto.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse getCategory(Long id);
    Page<CategoryResponse> listCategories(Pageable pageable);
    CategoryResponse updateCategory(Long id, CategoryRequest request);
    void deleteCategory(Long id);
}
