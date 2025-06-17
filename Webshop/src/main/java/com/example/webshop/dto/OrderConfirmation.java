package com.example.webshop.dto;
import java.time.LocalDateTime;

//dto??
public class OrderConfirmation {
    private long orderId;
    private double totalAmount;
    private String message;
    private LocalDateTime orderDate;

    public OrderConfirmation(long orderId, double totalAmount, String message, LocalDateTime orderDate){
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.message = message;
        this.orderDate = orderDate;
    }

    public long getOrderId(){
        return orderId;
    }
    public double getTotalAmount(){
        return totalAmount;
    }

    public String getMessage(){
        return message;
    }
    public LocalDateTime getOrderDate(){return orderDate;}
}
