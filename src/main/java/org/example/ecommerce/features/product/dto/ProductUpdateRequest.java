package org.example.ecommerce.features.product.dto;


import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Currency;

public record ProductUpdateRequest(

        @NotNull(message = "Product ID is required")
        Long id,

        @NotNull(message = "Product name is required")
        String name,

        @NotNull(message = "Product description is required")
        String description,

        @NotNull(message = "Product price is required")
        BigDecimal price,

        @NotNull(message = "Product currency is required")
        Currency currency,

        @NotNull(message = "Product unit measure is required")
        String unitMeasure,

        @NotNull(message = "Product stock quantity is required")
        Integer stockQuantity,

        boolean isActive
) {
}
