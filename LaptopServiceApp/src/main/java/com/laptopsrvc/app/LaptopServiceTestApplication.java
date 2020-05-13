package com.laptopsrvc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class LaptopServiceTestApplication {
    public static void main(String args[]) {

        SpringApplication app = new SpringApplication(LaptopServiceTestApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "4441"));
        app.run(args);
    }


}
