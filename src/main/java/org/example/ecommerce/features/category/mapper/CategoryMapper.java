package org.example.ecommerce.features.category.mapper;

import org.example.ecommerce.features.category.dto.CategoryResponse;
import org.example.ecommerce.features.category.model.Category;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING
)
public interface CategoryMapper {
    CategoryResponse toResponse(Category category);
}
