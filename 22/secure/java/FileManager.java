package com.cyberoctet.training.demo.secure.controller;

class FileManager {
    public String delete(String name) {
        // Remove any .. or . characters from the file name
        name = name.replaceAll("[\\.\\.|\\.]", "_");

        // Remove any unsafe characters from the file name
        name = name.replaceAll("[^a-zA-Z0-9]", "_");

        String path = "mydir/safe_path/" + name;

        File file = new File(path);

        if (!file.exists()) {
            return "File does not exist";
        }

        file.delete();

        return "File Deleted";
    }
}