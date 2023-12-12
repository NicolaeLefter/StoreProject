package com.example.StoreProject.controller.saleController;

import com.example.StoreProject.exception.saleException.SaleNotFoundException;
import com.example.StoreProject.exception.saleException.SaleUpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SaleControllerHandler {

    @ExceptionHandler(SaleNotFoundException.class)
    public ResponseEntity<Object> saleNotFoundException(SaleNotFoundException saleNotFoundException){

        Map<String, Object> map = new HashMap<>();
        map.put("message", saleNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
    @ExceptionHandler(SaleUpdateException.class)
    public ResponseEntity<Object> saleUpdateException(SaleUpdateException saleUpdateException){

        Map<String, Object> map = new HashMap<>();

        map.put("message", saleUpdateException.getMessage());
        map.put("dataTime", LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }
}
