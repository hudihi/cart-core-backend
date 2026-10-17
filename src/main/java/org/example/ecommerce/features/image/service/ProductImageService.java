package org.example.ecommerce.features.image.service;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.features.image.model.ProductImage;
import org.example.ecommerce.features.product.dto.ProductResponse;
import org.example.ecommerce.features.product.exception.ProductNotFoundException;
import org.example.ecommerce.features.product.mapper.ProductMapper;
import org.example.ecommerce.features.product.model.Product;
import org.example.ecommerce.features.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProductImageService {

    private final ProductRepository productRepository;
    private final FileStorageService fileStorageService;
    private final ProductMapper productMapper;

    @Transactional
    public ProductResponse uploadAndAddImageToProduct(Long productId, MultipartFile file, boolean isPrimary){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));

        String imageUrl = fileStorageService.uploadFile(file);

        ProductImage image = new ProductImage();
        image.setImageUrl(imageUrl);
        image.setPrimary(isPrimary);

        product.addImage(image);

        Product saveProduct = productRepository.save(product);

        return productMapper.toResponse(saveProduct);
    }
}
