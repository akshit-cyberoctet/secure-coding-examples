package com.cyberoctet.training.demo.secure.controller;

import org.springframework.beans.factory.annotation.Value;

public class HardCodedPassword {

    @Value("${adminPassword}")
    private String adminPassword;

    public boolean isValid(String password) {
        if (password.equals(adminPassword)) {
            return true;
        }
        
        return false;
    }
}
