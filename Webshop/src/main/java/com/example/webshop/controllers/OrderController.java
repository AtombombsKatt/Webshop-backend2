package com.example.webshop.controllers;
import com.example.webshop.model.Order;
import com.example.webshop.services.OrderService;
import com.example.webshop.dto.OrderConfirmation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){

        this.orderService = orderService;
    }

    @PostMapping
    public OrderConfirmation placeOrder(@Valid  @RequestBody Order order){

        return orderService.placeOrder(order);
    }
    //Hämta alla
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
//hämta order:id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }


}
