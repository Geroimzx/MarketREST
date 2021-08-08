package com.geroimzx.market.service;

import com.geroimzx.market.model.Product;
import com.geroimzx.market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
    }

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(String id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public Optional<Product> read(String id) {
        return productRepository.findById(id);
    }
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByType(String type) {
        return productRepository.findByType(type);
    }
}
