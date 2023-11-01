package com.stocktradingplatform.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @RequestMapping("/hello")
    public String greetings(){
        return "hello spring";
    }
}
