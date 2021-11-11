package com.l4yn3.microserviceseclab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping(value = "/ssrf")
public class SSRFController {

    @RequestMapping(value = "/one")
    public String One(@RequestParam(value = "url") String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            return connection.getResponseMessage();
        } catch (IOException var3) {
            System.out.println(var3);
            return "Hello";
        }
    }
}

