package com.cyberoctet.training.demo.secure.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller 
public class UploadController {

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    @GetMapping("/uploadimage") 
    public String displayUploadForm() {
        return "imageupload/index";
    }

    @PostMapping("/upload") 
    public String uploadImage(Model model, @RequestParam("image") MultipartFile file) throws IOException {
        // Check if the file is an image
        if (!file.getContentType().equals("image/jpeg")) {
            model.addAttribute("msg", "This file is not an image");
            return "imageupload/index";
        }

        StringBuilder fileNames = new StringBuilder();
        
        // Create a randomly generated file name for the uploaded file
        String originalFileName = file.getOriginalFilename();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String randomFileName = UUID.randomUUID().toString() + fileExtension;

        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, randomFileName);

        // Save the original file name and generated file name in an array
        String[] GeneratedfileName = {file.getOriginalFilename(), randomFileName};
        
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
        return "imageupload/index";
    }

    // Prevent Zip bomb
    public static void unzip() throws FileNotFoundException, IOException{
        byte[] buffer = new byte[1024];
        ZipFile zipfile = new ZipFile("zipbomb.zip");
        Enumeration zipEnum = zipfile.entries();
        
        while (zipEnum.hasMoreElements ()) 
        { 
            ZipEntry zipEntry = (ZipEntry) zipEnum.nextElement(); 
        
            File newFile = new File(zipEntry.getName());
            if (zipEntry.isDirectory()) newFile.mkdirs();
            else if(zipEntry.getSize() < (10 * 1024 * 1024)) { //<10MB
                
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                InputStream is = zipfile.getInputStream(zipEntry);
                while ((len = is.read(buffer)) > 0)
                    fos.write(buffer, 0, len);
                
                fos.close();
            }
            else
                System.out.println("File to big to extract");
        }
        zipfile.close();
        
    }
}