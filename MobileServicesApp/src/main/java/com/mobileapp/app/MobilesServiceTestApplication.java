package com.mobileapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class MobilesServiceTestApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MobilesServiceTestApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "4443"));
        app.run(args);
    }
}
