package com.example.webshop.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class CustomerInfo {
    @NotBlank(message = "namn får inte vara tomt")
    private String name;
    @NotBlank(message = "Du måste ange en adress")
    private String address;
    @NotBlank(message = "Email krävs")
    private String email;

    public CustomerInfo(){

    }
    public CustomerInfo(String name, String address, String email){
        this.name = name;
        this.address = address;
        this.email = email;
    }

    //get
    public String getName(){return name;}
    public String getAddress(){return address;}
    public String getEmail(){return email;}

    //set

    public void setName() {
        this.name = name;
    }
    public void setAddress(){
        this.address = address;
    }
    public void setEmail() {
        this.email = email;
    }
}

