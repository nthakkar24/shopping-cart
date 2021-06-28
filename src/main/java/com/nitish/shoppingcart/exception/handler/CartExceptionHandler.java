package com.nitish.shoppingcart.exception.handler;

import com.nitish.shoppingcart.bean.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CartExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public  ResponseEntity<List<ErrorResponse>> validationException(MethodArgumentNotValidException exe){

        List<ErrorResponse> errorResponses= exe.getFieldErrors().stream().map(error -> ErrorResponse.builder()
                .errorMessage(error.getDefaultMessage()).name(error.getField()).errorCode(error.getCode()).build())
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorResponses);
    }
}
