package org.example.ecommerce.features.category.dto;

public record CategoryResponse(
        Long id,
        String name,
        String slug,
        String description,
        boolean isActive
) {
}
