package dev.avishek.orderservice.services;

import dev.avishek.orderservice.dtos.ProductDto;

public interface ProductService {
    public ProductDto getProductById(Long productId);
}
