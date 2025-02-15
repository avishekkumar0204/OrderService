package dev.avishek.orderservice.services;

import dev.avishek.orderservice.dtos.OrderRequestDto;
import dev.avishek.orderservice.dtos.OrderResponseDto;
import dev.avishek.orderservice.dtos.ProductDto;
import dev.avishek.orderservice.exceptions.OrderNotFoundException;
import dev.avishek.orderservice.models.Order;
import dev.avishek.orderservice.models.OrderStatus;
import dev.avishek.orderservice.repositories.OrderRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ProductService productService;
    public OrderServiceImpl(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public Order createOrder(OrderRequestDto orderRequestDto) {
        Order order = orderRepository.save(convertOrderRequestDtoToOrder(orderRequestDto));
        return order;
    }
    public OrderResponseDto getOrder(Long id) throws OrderNotFoundException {
        Optional<Order> orderOptional =  orderRepository.findById(id);
        if(orderOptional.isEmpty()){
            throw new OrderNotFoundException("Order not found with id: "+id);
        }
        Order order = orderOptional.get();
        return convertOrderToOrderResponseDto(order);
    }

    public List<Order> getAllOrderOfUser(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    private Order convertOrderRequestDtoToOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setProductId(orderRequestDto.getProductId());
        order.setUserId(orderRequestDto.getUserId());
        return order;
    }

    private OrderResponseDto convertOrderToOrderResponseDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderStatus(order.getOrderStatus().name());
        Long productId = order.getProductId();
        ProductDto productDto = productService.getProductById(productId);
        orderResponseDto.setProductDetails(productDto);
        return orderResponseDto;
    }


}
