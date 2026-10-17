package org.example.ecommerce.features.image.mapper;


import org.example.ecommerce.features.image.dto.ProductImageResponse;
import org.example.ecommerce.features.image.model.ProductImage;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ProductImageMapper {
    ProductImageResponse toResponse(ProductImage productImage);
}
