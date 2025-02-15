package dev.avishek.orderservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private ProductDto productDetails;
    private UserDto user;
    private String orderStatus;
}
