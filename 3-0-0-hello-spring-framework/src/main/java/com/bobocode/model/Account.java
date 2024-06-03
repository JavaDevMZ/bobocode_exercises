package com.bobocode.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {

    private double balance;
    private String firstName;
    private String lastName;

    public Account(String firstName, String lastName, double balance){
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }
}
