package com.example.webshop.model;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

import com.example.webshop.services.OrderService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Order {
    private Long id;

    @Valid
    @NotNull
    private CustomerInfo customerInfo;

    @NotEmpty(message = "order måste innehålla minst en vara")
    @Valid
    private List<OrderItems> items;

    private double totalAmount;
    private LocalDateTime orderDate;

    public Order(){
        //tom konstruktor jackson JSON grejjen
    }
    public Order(Long id, CustomerInfo customerInfo, List<OrderItems> items, double totalAmount, LocalDateTime orderDate){
        this.id = id;
        this.customerInfo = customerInfo;
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }
//get
    public Long getId() {return id;}
    public CustomerInfo getCustomerInfo(){return customerInfo;}
    public List<OrderItems> getItems() {return items;}
    public double getTotalAmount(){return totalAmount;}
    public LocalDateTime getOrderDate(){ return orderDate;}
    // Setters
    public void setId(Long id) { this.id = id; }

    public void setCustomerInfo(CustomerInfo customerInfo) { this.customerInfo = customerInfo; }

    public void setItems(List<OrderItems> items) { this.items = items; }

    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

}

