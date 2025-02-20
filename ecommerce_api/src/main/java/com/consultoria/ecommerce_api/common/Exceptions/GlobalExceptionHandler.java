package com.consultoria.ecommerce_api.common.Exceptions;

import com.consultoria.ecommerce_api.common.constants.MessageConstants;
import com.consultoria.ecommerce_api.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejo de excepciones de validación (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        ApiResponse apiResponse = new ApiResponse(false, "Validation Error", errors // Include validation errors in the data field
        );

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    // Manejo de excepciones genéricas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGlobalExceptions(Exception ex, WebRequest request) {
        ApiResponse apiResponse = new ApiResponse(false, MessageConstants.MESSAGE_ERROR, ex.getMessage() // Include exception message in the data field
        );

        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Manejo de excepciones personalizadas (ejemplo: recurso no encontrado)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse> handleNotFoundException(RuntimeException ex, WebRequest request) {
        ApiResponse apiResponse = new ApiResponse(false, MessageConstants.MESSAGE_FOUND, ex.getMessage() // Include exception message in the data field
        );

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
