package com.example.webshop.controllers;

import com.example.webshop.model.Product;
import com.example.webshop.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    }
    // api/products
    @GetMapping
    public List<Product>getAllProducts(){
        return productService.getAllProducts();
    }

    //api/products/id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){ //req.params.id i express typ
        return productService.getProductById(id);
    }
    //skapa produkt
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }


}
