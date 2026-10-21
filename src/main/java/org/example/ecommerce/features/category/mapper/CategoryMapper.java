package org.example.ecommerce.features.category.mapper;

import org.example.ecommerce.features.category.dto.CategoryRequest;
import org.example.ecommerce.features.category.dto.CategoryResponse;
import org.example.ecommerce.features.category.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(
        componentModel = SPRING,
        unmappedTargetPolicy = IGNORE
)
public interface CategoryMapper {
    @Mapper()
    Category toEntity(CategoryRequest request);
    CategoryResponse toResponse(Category category);
}
