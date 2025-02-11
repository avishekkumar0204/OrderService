package dev.avishek.orderservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseModel{
    private Long productId;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.PENDING;
    private Double orderAmount;
}
