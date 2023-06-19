package com.myapp.moneytransferapplication;


public class Customer {
    int id;
    String name;
    String email;
    double balance;

    public Customer() {
    }

    public Customer(int id, String name, String email, double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }


    public int getId(){return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

}
