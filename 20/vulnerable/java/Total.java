package com.cyberoctet.training.demo.vulnerable.controller;

public class Total {
    public String charges(int quantity) {
        double price = 20.0;

        double total = quantity * price;

        return String.format("Total: %s", total);
    }
}

// Negative value can be passed in the quantity by the user that may credit the account instead of debiting.