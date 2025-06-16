package com.buttercms.springstarterbuttercms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;

@SpringBootApplication
public class SpringStarterButtercmsApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(SpringStarterButtercmsApplication.class, args);

        // Get the port
        if (context instanceof ServletWebServerApplicationContext webContext) {
            int port = webContext.getWebServer().getPort();
            System.out.println("Application running on port: " + port);
        }
    }

}
