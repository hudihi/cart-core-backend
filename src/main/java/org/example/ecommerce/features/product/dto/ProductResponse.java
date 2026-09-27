package org.example.ecommerce.features.product.dto;

import org.example.ecommerce.features.category.dto.CategoryResponse;

import java.math.BigDecimal;
import java.util.Currency;

public record ProductResponse(
        String name,
        String description,
        BigDecimal price,
        Currency currency,
        String unitMeasure,
        Integer stockQuantity,
        boolean isActive,
        CategoryResponse category,
        List<ProductImageResponse> images
) {
}
