package dev.avishek.orderservice.dtos;

import dev.avishek.orderservice.models.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private Long productId;
    private Long userId;
    private Double orderAmount;
}
