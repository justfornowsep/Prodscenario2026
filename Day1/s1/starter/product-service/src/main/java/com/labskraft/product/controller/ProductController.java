package com.labskraft.product.controller;

import com.labskraft.product.model.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Pre-populated product catalog
    private final Map<Long, Product> products = Map.of(
        1L, new Product(1L, "Laptop", 50000.0),
        2L, new Product(2L, "Monitor", 12000.0),
        3L, new Product(3L, "Keyboard", 2500.0)
    );

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {

        Product product = products.get(id);

        if (product == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Product not found: " + id
            );
        }

        return product;
    }
}