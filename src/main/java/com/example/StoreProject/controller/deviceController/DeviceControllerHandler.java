package com.example.StoreProject.controller.deviceController;

import com.example.StoreProject.exception.depositException.DepositUpdateException;
import com.example.StoreProject.exception.deviceException.DeviceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DeviceControllerHandler {

    @ExceptionHandler(DeviceNotFoundException.class)
    public ResponseEntity<Object> deviceNotFoundException(DeviceNotFoundException deviceNotFoundException) {
        Map<String, Object> map = new HashMap<>();

        map.put("message", deviceNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @ExceptionHandler(DepositUpdateException.class)
    public ResponseEntity<Object> deviceUpdateException(DepositUpdateException depositUpdateException) {

        Map<String, Object> map = new HashMap<>();

        map.put("message", depositUpdateException.getMessage());
        map.put("dataTime", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

}
