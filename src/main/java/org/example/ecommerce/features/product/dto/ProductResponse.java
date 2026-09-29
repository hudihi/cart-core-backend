package org.example.ecommerce.features.product.dto;

import org.example.ecommerce.features.category.dto.CategoryResponse;
import org.example.ecommerce.features.category.model.Category;
import org.example.ecommerce.features.image.dto.ProductImageResponse;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Currency currency,
        String unitMeasure,
        Integer stockQuantity,
        boolean isActive,
        CategoryResponse category,
        List<ProductImageResponse> images
) {}
