package org.example.ecommerce.features.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(
        @NotBlank(message = "Category name is mandatory")
        @NotEmpty(message = "Category name is mandatory")
        String name,
        String slug,
        String description,
        boolean isActive
) {
}
