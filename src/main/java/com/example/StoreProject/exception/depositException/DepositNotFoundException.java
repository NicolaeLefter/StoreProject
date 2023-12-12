package com.example.StoreProject.exception.depositException;

public class DepositNotFoundException extends RuntimeException{

    public DepositNotFoundException(String message){
        super(message);
    }
}
