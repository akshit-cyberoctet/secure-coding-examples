package com.cyberoctet.training.demo.secure.controller;

public class Total {
    public String charges(int quantity) {
        if (quantity < 0) {
            return "Error: Negative quantity";
        }
        double price = 20.0;

        double total = quantity * price;

        return String.format("Total: %s", total);
    }
}

// The inputs must be validated for the expected values of the quantity.