package com.example.StoreProject.controller.storeController;

import com.example.StoreProject.exception.storeException.StoreNotFoundException;
import com.example.StoreProject.exception.storeException.StoreUpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class StoreControllerHandler {

    @ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<Object> storeNotFoundException(StoreNotFoundException storeNotFoundException) {

        Map<String, Object> map = new HashMap<>();

        map.put("message", storeNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @ExceptionHandler(StoreUpdateException.class)
    public ResponseEntity<Object> storeUpdateException(StoreUpdateException storeUpdateException) {

        Map<String, Object> map = new HashMap<>();
        map.put("message", storeUpdateException.getMessage());
        map.put("dataTime", LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }
}
