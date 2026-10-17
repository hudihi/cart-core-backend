package org.example.ecommerce.features.product.mapper;


import org.example.ecommerce.features.category.mapper.CategoryMapper;
import org.example.ecommerce.features.image.mapper.ProductImageMapper;
import org.example.ecommerce.features.product.dto.ProductRequest;
import org.example.ecommerce.features.product.dto.ProductResponse;
import org.example.ecommerce.features.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(
        componentModel = SPRING,
        unmappedTargetPolicy = IGNORE,
        uses = {CategoryMapper.class, ProductImageMapper.class}
)
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "images", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Product toEntity(ProductRequest request);


    @Mapping(target = "category", source = "category")
    @Mapping(target = "images", source = "images")
    ProductResponse toResponse(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "images", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateProductFromDto(ProductRequest request, @MappingTarget Product product);


}
