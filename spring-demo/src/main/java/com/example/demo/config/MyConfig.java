package com.example.demo.config;

import com.example.demo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"controller"})
public class MyConfig {
    @Bean
    public Student student() {
        return new Student();
    }
}
