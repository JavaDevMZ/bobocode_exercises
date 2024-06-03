package com.bobocode;

import com.bobocode.model.Account;

import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {

    public Account generateAccount(){
        String firstName = "";
        String lastName = "";
        double balance = Math.random() * 1000;
      for(int i = 0; i<10; i++) {
        firstName += (char)(61+(int)(Math.random()*26));
        lastName += (char)(61+(int)(Math.random()*26));
      }
        return new Account(firstName, lastName, balance);
    }
}
