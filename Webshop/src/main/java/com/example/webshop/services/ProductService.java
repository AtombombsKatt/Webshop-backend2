package com.example.webshop.services;

import com.example.webshop.exceptions.ProductNotFoundException;
import com.example.webshop.model.Product;
import com.example.webshop.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(id ));
    }
    public Product createProduct(Product product) {
        productRepo.save(product);
        return product;
    }
}



