package com.stocktradingplatform.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktradingplatform.backend.bean.UserBean;
import com.stocktradingplatform.backend.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    
    @RequestMapping("/hello")
    public String greetings(){
        return "hello spring";
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserBean>> getUserDetails(String email){
        System.out.println(email);
       return new ResponseEntity<>(userService.getUserDetails(email), HttpStatus.OK);
    }
}
