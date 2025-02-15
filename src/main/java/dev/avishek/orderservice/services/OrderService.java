package dev.avishek.orderservice.services;

import dev.avishek.orderservice.dtos.OrderRequestDto;
import dev.avishek.orderservice.dtos.OrderResponseDto;
import dev.avishek.orderservice.exceptions.OrderNotFoundException;
import dev.avishek.orderservice.models.Order;
import java.util.List;

public interface OrderService {
    Order createOrder(OrderRequestDto orderRequestDto);
    List<Order> getAllOrderOfUser(Long userId);
    OrderResponseDto getOrder(Long id) throws OrderNotFoundException;
}
