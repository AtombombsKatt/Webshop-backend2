package com.example.webshop.repository;

import com.example.webshop.model.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepository(){
        products.add(new Product(1L, "Gummi Stövlar", "Friluftsliv", 359.99, "",  11));
        products.add(new Product(2L, "Sneakers", "Vardag", 199.99, "" , 23));
        products.add(new Product(3L, "Flip-flops", "Vardag", 99.99, "", 50));
        products.add(new Product(4L, "Vandrings Kängor", "Friluftsliv", 950.00, "", 50));
        products.add(new Product(5L, "Spring Skor", "Sport", 499.99, "", 5));
        products.add(new Product(6L, "Fotbolls Skor", "Sport", 300.00, "", 12));
        products.add(new Product(7L, "Tofflor", "Vardag", 129.99, "", 0));
        products.add(new Product(8L, "Converse", "Vardag", 199.99, "", 25));
        products.add(new Product(9L, "Boxnings Skor", "Sport", 315.99, "", 10));
        products.add(new Product(10L, "Foppa-Tofflor", "Vardag", 59.99, "", 123));
    }

    public List<Product>findAll(){
        return products;
    }

    public Optional<Product> findById(Long id){
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

    }
    public void save(Product product) {
        products.add(product);
    }
}

