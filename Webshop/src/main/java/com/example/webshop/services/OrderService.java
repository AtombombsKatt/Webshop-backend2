package com.example.webshop.services;

import com.example.webshop.model.Order;
import com.example.webshop.model.OrderItems;
import com.example.webshop.repository.OrderRepository;
import com.example.webshop.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.example.webshop.model.Product;
import com.example.webshop.dto.OrderConfirmation;
import com.example.webshop.exceptions.ProductNotFoundException;
import com.example.webshop.exceptions.OutOfStockException;
import com.example.webshop.exceptions.InvalidOrderException;
import com.example.webshop.exceptions.OrderNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private long currentOrderId = 1;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository){
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderConfirmation placeOrder(Order order){
        double totalAmount = 0;
        for(OrderItems item: order.getItems()){
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException(item.getProductId()));

            //minst 1 produkt
            if (order.getItems() == null || order.getItems().isEmpty()) {
                throw new InvalidOrderException("Order måste innehålla minst en vara");
            }
            System.out.println("Product price: " + product.getPrice());
            System.out.println("Item quantity: " + item.getQuantity());
            //kolla om de finns i lager
            if (product.getStock() < item.getQuantity()) {
                throw new OutOfStockException("PRodukten är slut i lager " + product.getTitle());
            }
            // spara nya stock i collectionen
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);

            item.setPriceAtPurchase(product.getPrice());
            totalAmount += product.getPrice()* item.getQuantity();
        }
        order.setId(currentOrderId++);
        order.setTotalAmount(totalAmount);
        order.setOrderDate(LocalDateTime.now());

        orderRepository.save(order);
        return new OrderConfirmation(order.getId(), order.getTotalAmount(), "Order bekräftad! summa " + totalAmount + " Order nummer: " + order.getId(), order.getOrderDate());
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

}
