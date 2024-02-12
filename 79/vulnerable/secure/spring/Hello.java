package com.cyberoctet.training.secure.demo;

import org.springframework.web.bind.annotation.RestController;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Training {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        // The context is to just show the name as label, so, we don't need any HTML tags. 
        // Better to strip all the html tags
        name = name.replaceAll("\\<.*?\\>", "");

        return String.format("Hello %s!", name);
    }

    @GetMapping("/comment")
    public String comment(@RequestParam(value = "comment", defaultValue = "World") String comment) {
        // The context is to just show the comment that supports HTML, so, we need to sanitize the HTML
        comment = Jsoup.clean(comment, Safelist.basic());

        return String.format("<p>%s</p>", comment);
    }
}

// Jsoup reference: https://github.com/jhy/jsoup/