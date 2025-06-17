package com.example.webshop.model;

public class OrderItems {
    private Long productId;
    private int quantity;
    private double priceAtPurchase;
    public OrderItems(Long productId, int quantity, double priceAtPurchase){
        this.productId = productId;
        this.quantity = quantity;
        this.priceAtPurchase = priceAtPurchase;
    }

   // getters
    public Long getProductId() {return productId;}

    public int getQuantity() {return quantity;}

    public double getPriceAtPurchase() {return priceAtPurchase;}

    // Setters
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPriceAtPurchase(double priceAtPurchase) {
        this.priceAtPurchase = priceAtPurchase;
    }

    // Behövs för JSON (t.ex. vid POST) – tom konstruktor
    public OrderItems() {
    }
}
