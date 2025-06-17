package com.example.webshop.exceptions;


public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id){
        super("Ordder med id " + id + " Hittades inte");
    }
}
