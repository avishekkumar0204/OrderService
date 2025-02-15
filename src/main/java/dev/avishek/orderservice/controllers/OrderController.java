package dev.avishek.orderservice.controllers;

import dev.avishek.orderservice.dtos.OrderRequestDto;
import dev.avishek.orderservice.dtos.OrderResponseDto;
import dev.avishek.orderservice.exceptions.OrderNotFoundException;
import dev.avishek.orderservice.models.Order;
import dev.avishek.orderservice.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable("id") Long id) throws OrderNotFoundException {
        OrderResponseDto order = orderService.getOrder(id);
        ResponseEntity<OrderResponseDto> responseEntity = new ResponseEntity<>(
                order,
                HttpStatus.OK
        );
        return responseEntity;
    }

    @GetMapping("/user/{userId}")
    public List<Order> getAllOrderOfUser(@PathVariable("userId") Long userId) {
        return orderService.getAllOrderOfUser(userId);
    }

    @PostMapping()
    public Order createOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.createOrder(requestDto);
    }
}
