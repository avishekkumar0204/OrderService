package dev.avishek.orderservice.controlleradvice;

import dev.avishek.orderservice.dtos.ExceptionDto;
import dev.avishek.orderservice.exceptions.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleOrderNotFoundException(OrderNotFoundException exception) {
        ExceptionDto exceptionDto = new ExceptionDto(exception.getMessage(), "Please check the order id and try again");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.NOT_FOUND
        );
        return responseEntity;
    }
}
