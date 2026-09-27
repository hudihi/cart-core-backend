package org.example.ecommerce.features.product.service;

import org.example.ecommerce.features.product.dto.ProductRequest;
import org.example.ecommerce.features.product.dto.ProductResponse;
import org.example.ecommerce.features.product.dto.ProductUpdateRequest;
import org.example.ecommerce.features.product.model.Product;
import org.example.ecommerce.features.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    ProductServiceImpl(ProductRepository repo){
        this.repo = repo;
    }


    @Override
    public Product createProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return repo.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found with id: " + id)
        );
    }

    @Override
    public List<Product> listProducts() {
        return repo.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existProduct = repo.findById(id).orElseThrow(
                () -> new RuntimeException("Product with id " + id + "not found")
        );

        existProduct.setName(product.getName() != null ? product.getName() : existProduct.getName());
        existProduct.setPrice(product.getPrice() != null ? product.getPrice() : existProduct.getPrice());
        existProduct.setDescription(product.getDescription() != null ? product.getDescription() : existProduct.getDescription());
        existProduct.setCurrency(product.getCurrency() != null ? product.getCurrency() : existProduct.getCurrency());
        existProduct.setActive(product.isActive() || existProduct.isActive());

        return repo.save(existProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}
