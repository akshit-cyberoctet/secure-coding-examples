package com.cyberoctet.training.demo.vulnerable.controller;

import org.springframework.web.bind.annotation.RequestParam;

public class Backup {
    public String backup(@RequestParam(value = "type", defaultValue = "complete") String type) {

        String cmd = "runbackup.sh " + type;

        try {
            Runtime rt = Runtime.getRuntime();
            Process exec = rt.exec("runbackup.sh " + type);
            
        }
        catch(Exception e) {
            // Manage exceptions here
        }

        return "Backup done";
    }
}
