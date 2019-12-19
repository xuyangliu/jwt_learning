package com.peanut.jwt_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.peanut.jwt_learning")
@SpringBootApplication
public class JwtLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtLearningApplication.class, args);
    }

}
