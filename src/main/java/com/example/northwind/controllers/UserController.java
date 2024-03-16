package com.example.northwind.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "output")
    public String outputText(){
        return "User controller output text";
    }

}
