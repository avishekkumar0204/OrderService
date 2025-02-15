package dev.avishek.orderservice.services;

import dev.avishek.orderservice.dtos.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {
    private RestTemplate restTemplate;
    public ProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public ProductDto getProductById(Long productId) {
        ResponseEntity<ProductDto> productDto  = restTemplate.getForEntity(
                "http://localhost:8080/products/"+productId,
                ProductDto.class
        );
        return productDto.getBody();
    }
}
