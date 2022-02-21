package com.zhevakin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class VacancyServiceBasicAuth {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(VacancyServiceBasicAuth.class);

        app.setDefaultProperties(Collections.<String, Object>singletonMap("server.port", "8084"));
        app.run(args);

    }
}
