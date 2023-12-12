package com.example.StoreProject.controller.depositController;

import com.example.StoreProject.exception.depositException.DepositNotFoundException;
import com.example.StoreProject.exception.depositException.DepositUpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DepositControllerHandler {
    @ExceptionHandler(DepositNotFoundException.class)
    public ResponseEntity<Object> depositNotFoundException(DepositNotFoundException depositNotFoundException){
        Map<String, Object> map = new HashMap<>();

        map.put("message", depositNotFoundException.getMessage());
        map.put("LocalDataTime", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
    @ExceptionHandler(DepositUpdateException.class)
    public ResponseEntity<Object> updateDepositException(DepositUpdateException depositUpdateException){
        Map<String, Object> map  =  new HashMap<>();

        map.put("message", "Nu s-a primit actualizarea depositului!" + depositUpdateException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);

    }





}
