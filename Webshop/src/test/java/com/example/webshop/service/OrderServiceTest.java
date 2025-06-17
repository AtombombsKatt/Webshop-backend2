package com.example.webshop.service;

import com.example.webshop.dto.OrderConfirmation;
import com.example.webshop.exceptions.OutOfStockException;
import com.example.webshop.exceptions.ProductNotFoundException;
import com.example.webshop.model.*;
import com.example.webshop.repository.OrderRepository;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.services.OrderService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private ProductRepository productRepo;

    @Mock
    private OrderRepository orderRepo;

    @InjectMocks
    private OrderService orderService;
//Lagerstatus minskar test, totalasumman test
    @Test
    void testPlaceOrder_successful() {
        Product product = new Product(1L, "Test Produkt", "Beskrivning", 100.0, "", 10);
        OrderItems item = new OrderItems(1L, 2, 100.0); // rätt konstruktor
        CustomerInfo customer = new CustomerInfo("Test klas", "Testvägen 7", "test@example.com");
        Order order = new Order(null, customer, List.of(item), 0.0, null);

        when(productRepo.findById(1L)).thenReturn(Optional.of(product));

        OrderConfirmation confirmation = orderService.placeOrder(order);

        assertEquals(200.0, confirmation.getTotalAmount());
        assertEquals(8, product.getStock()); // 10 - 2
        verify(orderRepo).save(any(Order.class));
    }
// köp av produkt som inte finns test
    @Test
    void testPlaceOrder_productNotFound() {
        OrderItems item = new OrderItems(999L, 1, 0.0);
        CustomerInfo customer = new CustomerInfo("Test Elin", "Testgvägen 4", "test@example.com");
        Order order = new Order(null, customer, List.of(item), 0.0, null);

        when(productRepo.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> orderService.placeOrder(order));
    }
// slut i lager test
    @Test
    void testPlaceOrder_outOfStock() {
        Product product = new Product(1L, "Slut i lager", "Beskrivning", 100.0, "", 1);
        OrderItems item = new OrderItems(1L, 5, 100.0); // vill ha 5, finns 1
        CustomerInfo customer = new CustomerInfo("Test sara", "Testvägen 3", "test@example.com");
        Order order = new Order(null, customer, List.of(item), 0.0, null);

        when(productRepo.findById(1L)).thenReturn(Optional.of(product));

        assertThrows(OutOfStockException.class, () -> orderService.placeOrder(order));
    }
}
