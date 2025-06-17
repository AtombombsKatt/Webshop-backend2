package com.example.webshop.model;

import jakarta.validation.constraints.*;

public class Product {
    private Long id;
    @NotBlank(message = "produkt måste ha en titel")
    private String title;

    @NotBlank(message = "produkten måste ha en beskrivni")
    private String description;
    @NotNull(message = "Varan måste ha ett pris")
    @Min(value = 10, message = "Priset kan inte vara mindre än 10kr")
    private double price;

    private String imageUrl;
    @NotNull(message = "Måste finns ett antal i lager")
    @Min(value = 0, message = "Kan inte finnas negativt antal ilager")
    private Integer stock;

    public Product(Long id, String title, String description, double price, String imageUrl, Integer stock){
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.stock = stock;

    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl(){ return imageUrl;}

    public Integer getStock() { return stock;}
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}


