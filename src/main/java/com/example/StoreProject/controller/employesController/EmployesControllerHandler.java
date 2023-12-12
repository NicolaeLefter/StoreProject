package com.example.StoreProject.controller.employesController;

import com.example.StoreProject.exception.employesException.EmployesNotFoundException;
import com.example.StoreProject.exception.employesException.EmployesUpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EmployesControllerHandler {
    @ExceptionHandler(EmployesNotFoundException.class)
    public ResponseEntity<Object> employesNotFoundException(EmployesNotFoundException employesNotFoundException) {

        Map<String, Object> map = new HashMap<>();

        map.put("message", employesNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
    @ExceptionHandler(EmployesUpdateException.class)
    public ResponseEntity<Object> employesUpdateException(EmployesUpdateException employesUpdateException){

        Map<String, Object> map = new HashMap<>();
        map.put("message", employesUpdateException.getMessage());
        map.put("dataTime", LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }
}
