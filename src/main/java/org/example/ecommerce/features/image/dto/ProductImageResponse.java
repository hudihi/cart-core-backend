package org.example.ecommerce.features.image.dto;

public record ProductImageResponse(Long id, String url, boolean isPrimary, Integer sortOrder) { }
