package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to keep Note";
    }
}
