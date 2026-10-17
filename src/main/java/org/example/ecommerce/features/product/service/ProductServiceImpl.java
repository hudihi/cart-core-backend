package org.example.ecommerce.features.product.service;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.features.category.model.Category;
import org.example.ecommerce.features.category.repository.CategoryRepository;
import org.example.ecommerce.features.product.dto.ProductRequest;
import org.example.ecommerce.features.product.dto.ProductResponse;
import org.example.ecommerce.features.product.exception.ProductNotFoundException;
import org.example.ecommerce.features.product.mapper.ProductMapper;
import org.example.ecommerce.features.product.model.Product;
import org.example.ecommerce.features.product.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;


    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = productMapper.toEntity(request);
        Category category = categoryRepository.getReferenceById(request.categoryId());
        product.setCategory(category);
        Product saveProduct = productRepository.save(product);
        return productMapper.toResponse(saveProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return productMapper.toResponse(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductResponse> listProducts(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.map(productMapper::toResponse);
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product existProduct = productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product not found with id:  " + id));
        productMapper.updateProductFromDto(request, existProduct);
        if (request.categoryId() != null && !existProduct.getCategory().getId().equals(request.categoryId())){
            Category newCategory = categoryRepository.getReferenceById(request.categoryId());
            existProduct.setCategory(newCategory);
        }
        Product updatedProduct = productRepository.save(existProduct);
        return productMapper.toResponse(updatedProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        product.setActive(false);
        productRepository.save(product);
    }

}
