package com.example.webshop.service;
import com.example.webshop.services.ProductService;
import com.example.webshop.model.Product;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.BeforeEach;
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
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepo;

    @InjectMocks
    private ProductService productService;
//hämta produkter test
    @Test
    void testGetAllProducts_returnsList() {
        // Arrange
        List<Product> mockProducts = List.of(
                new Product(1L, "Test1", "Desc1", 105, "", 7),
                new Product(2L, "Test2", "Desc2", 99.0, "", 22)
        );
        when(productRepo.findAll()).thenReturn(mockProducts);

        // Act
        List<Product> products = productService.getAllProducts();

        // Assert
        assertNotNull(products);
        assertEquals(2, products.size());
        verify(productRepo).findAll();
    }
//hämta via :id test
    @Test
    void testGetProductById_returnsProduct() {
        // Arrange
        Product product = new Product(1L, "Test1", "Desc1", 100, "", 10);
        when(productRepo.findById(1L)).thenReturn(Optional.of(product));

        // Act
        Product result = productService.getProductById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Test1", result.getTitle());
    }
// exception vid fel :id test
    @Test
    void testGetProductById_throwsException() {
        // Arrange
        when(productRepo.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ProductNotFoundException.class, () -> {
            productService.getProductById(999L);
        });
    }
}

