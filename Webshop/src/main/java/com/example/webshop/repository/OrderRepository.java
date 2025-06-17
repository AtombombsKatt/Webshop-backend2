package com.example.webshop.repository;

import com.example.webshop.model.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    public void save(Order order){
        orders.add(order);
    }

    public List<Order>findAll(){
        return orders;
    }

    public Optional<Order> findById(Long id){
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst();
    }
}
