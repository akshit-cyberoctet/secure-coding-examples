package com.cyberoctet.training.demo.secure.controller;

import org.springframework.web.bind.annotation.RequestParam;

public class Backup {
    public String backup(@RequestParam(value = "type", defaultValue = "complete") String type) {

        // You must test if the value is a valid input
        String[] validTypes = {"complete", "incremental"};

        // Check if the specified input is valid
        if(!java.util.Arrays.asList(validTypes).contains(type)) {
            return "Invalid type";
        }

        try {
            String[] commands = {"runbackup.sh", type};

            ProcessBuilder pb = new ProcessBuilder(commands);
            pb.start();
        }
        catch(Exception e) {
            // Manage exceptions here
        }

        return "Backup done";
    }
}
