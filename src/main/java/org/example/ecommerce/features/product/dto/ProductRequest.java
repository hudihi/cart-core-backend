package org.example.ecommerce.features.product.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Currency;

public record ProductRequest(
        @NotBlank(message = "Product name is mandatory")
        @NotEmpty(message = "Product name is mandatory")
        String name,

        @NotEmpty(message = "Product description is mandatory")
        @NotBlank(message = "Product description is mandatory")
        String description,

        @NotEmpty(message = "Product price is mandatory")
        @NotBlank(message = "Product price is mandatory")
        @DecimalMin(value = "1000.00", message = "Price should be not less than 1000.00")
        @DecimalMax(value = "999,999,999", message = "Price should not exceed 999,999,999")
        @PositiveOrZero(message = "Price cannot be negative")
        BigDecimal price,

        @NotBlank(message = "Currency is mandatory")
        @NotEmpty(message = "Currency is mandatory")
        Currency currency,

        @NotBlank(message = "Unit measure is mandatory")
        @NotEmpty(message = "Unit Measure is mandatory")
        String unitMeasure,

        @NotBlank(message = "Stock Quantity is mandatory")
        @NotEmpty(message = "StockQuantity is mandatory")
        Integer stockQuantity,

        @NotEmpty(message = "state of the product is mandatory")
        @NotBlank(message = "state of the product is mandatory")
        boolean isActive
        ) { }
