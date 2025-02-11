package dev.avishek.orderservice.services;

import dev.avishek.orderservice.dtos.OrderRequestDto;
import dev.avishek.orderservice.models.Order;
import dev.avishek.orderservice.repositories.OrderRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order createOrder(OrderRequestDto orderRequestDto) {
        Order order = orderRepository.save(convertOrderRequestDtoToOrder(orderRequestDto));
        return order;
    }


    private Order convertOrderRequestDtoToOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setProductId(orderRequestDto.getProductId());
        order.setUserId(orderRequestDto.getUserId());
        order.setOrderAmount(orderRequestDto.getOrderAmount());
        return order;
    }

}
