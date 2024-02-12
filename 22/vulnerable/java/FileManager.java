package com.cyberoctet.training.demo.vulnerable.controller;

class FileManager {
    public String delete(String name) {
        String path = "mydir/safe_path/" + name;

        File file = new File(path);

        file.delete();

        return "File Deleted";
    }
}