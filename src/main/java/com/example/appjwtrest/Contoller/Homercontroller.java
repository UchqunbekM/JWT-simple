package com.example.appjwtrest.Contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Homercontroller {

    @GetMapping
    public String getHome(){
        return "Welcome home page";
    }
}
