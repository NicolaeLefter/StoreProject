package com.example.StoreProject.controller.clientController;

import com.example.StoreProject.exception.clientException.ClientNotFoundException;
import com.example.StoreProject.exception.clientException.ClientUpdateException;
import jakarta.websocket.OnClose;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ClientControllerHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Object> clientNotFoundException(ClientNotFoundException clientNotFoundException){

        Map<String, Object>map = new HashMap<>();

        map.put("message", clientNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
    @ExceptionHandler(ClientUpdateException.class)
    public ResponseEntity<Object> clientUpdateException(ClientUpdateException clientUpdateException){
        Map<String, Object> map = new HashMap<>();

        map.put("message", clientUpdateException.getMessage());
        map.put("dataTime", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }
}
