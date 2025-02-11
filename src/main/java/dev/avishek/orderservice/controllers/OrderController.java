package dev.avishek.orderservice.controllers;

import dev.avishek.orderservice.dtos.OrderRequestDto;
import dev.avishek.orderservice.models.Order;
import dev.avishek.orderservice.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping()
    public Order createOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.createOrder(requestDto);
    }
}
