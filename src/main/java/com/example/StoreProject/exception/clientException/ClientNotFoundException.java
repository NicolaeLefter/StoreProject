package com.example.StoreProject.exception.clientException;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(String message){
        super(message);
    }
}
