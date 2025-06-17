package com.example.webshop.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Produkt med ID " + id + " hittades inte.");
    }

}
