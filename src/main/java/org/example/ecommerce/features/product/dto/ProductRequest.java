package org.example.ecommerce.features.product.dto;

import java.math.BigDecimal;
import java.util.Currency;

public record ProductRequest(
        String name,
        String description,
        BigDecimal price,
        Currency currency,
        String unitMeasure,
        Integer stockQuantity,
        boolean isActive
        ) { }
