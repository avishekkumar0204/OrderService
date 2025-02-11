package dev.avishek.orderservice.services;

import dev.avishek.orderservice.dtos.OrderRequestDto;
import dev.avishek.orderservice.exceptions.OrderNotFoundException;
import dev.avishek.orderservice.models.Order;

public interface OrderService {
    Order createOrder(OrderRequestDto orderRequestDto);
    Order getOrder(Long id) throws OrderNotFoundException;
}
