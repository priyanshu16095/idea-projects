package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginConroller {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
