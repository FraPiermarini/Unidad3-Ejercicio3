package com.programacion4.unidad3ej3.config;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.Instant;
import java.util.List;

import com.programacion4.unidad3ej3.config.exceptions.CustomException;
import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja las excepciones personalizadas
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseResponse<Object>> handleCustomException(CustomException ex) {
        BaseResponse<Object> response = BaseResponse.builder()
                .message(ex.getMessage())
                .errors(ex.getErrors())
                .timestamp(Instant.now().toString())
                .build();

        return new ResponseEntity<>(response, ex.getStatus());
    }

    /**
     * Maneja errores de recurso no encontrado (HU03)
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BaseResponse<Object>> handleNotFound(ResourceNotFoundException ex) {

        BaseResponse<Object> response = BaseResponse.builder()
                .message(ex.getMessage())
                .errors(List.of("Recurso no encontrado"))
                .timestamp(Instant.now().toString())
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja las excepciones de validación
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Object>> handleValidation(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + ": " + f.getDefaultMessage())
                .toList();

        BaseResponse<Object> response = BaseResponse.builder()
                .message("Error de validación")
                .errors(errors)
                .timestamp(Instant.now().toString())
                .build();

        return ResponseEntity.badRequest().body(response);
    }

    /**
     * Maneja las excepciones genéricas
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Object>> handleGeneric(Exception ex) {

        ex.printStackTrace();

        BaseResponse<Object> response = BaseResponse.builder()
                .message("Ocurrió un error inesperado")
                .errors(List.of(ex.getMessage()))
                .timestamp(Instant.now().toString())
                .build();

        return ResponseEntity.internalServerError().body(response);
    }
}