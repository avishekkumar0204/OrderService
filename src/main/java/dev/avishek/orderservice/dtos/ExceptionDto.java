package dev.avishek.orderservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionDto {
    private String message;
    private String solution;
}
