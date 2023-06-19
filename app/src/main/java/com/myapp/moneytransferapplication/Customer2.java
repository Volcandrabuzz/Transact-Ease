package com.myapp.moneytransferapplication;


import android.widget.Button;

public class Customer2 {
    String name;
    String email;
    double balance;

    public Customer2() {
    }

    public Customer2(int id, String name, String email, double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public String callName() {
        return name;
    }

    public String callEmail() {
        return email;
    }

    public double callBalance() {
        return balance;
    }

}
