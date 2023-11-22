package com.stocktradingplatform.backend.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.stocktradingplatform.backend.bean.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stocktradingplatform.backend.bean.LoginCredentials;
import com.stocktradingplatform.backend.bean.UserBean;
import com.stocktradingplatform.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String greetings() {
        return "hello spring";
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserBean>> getUserDetails(String email) {
        System.out.println(email);
        return new ResponseEntity<>(userService.getUserDetails(email), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserBean>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UserBean>> getUserById(@PathVariable Integer id) {
        System.out.println(id);
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/register", consumes="application/json")
    public ResponseEntity<List<UserRegister>> register(@RequestBody UserRegister userRegistration) {
        System.out.println(userRegistration.getEmail() + " : " + userRegistration.getPassword());
        userService.createUser(userRegistration);
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<List<UserBean>> login(@RequestBody LoginCredentials loginCredentials) {
        List<UserBean> userBeanList = new ArrayList<>();
        try {
            userBeanList = userService.loginUser(loginCredentials);
            if (!userBeanList.isEmpty()) {
                System.out.println(userBeanList);
            } else {
                return new ResponseEntity<>(userBeanList, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(userBeanList, HttpStatus.OK);
    }

    @GetMapping("/getBalance/{id}")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Integer id){
        return new ResponseEntity<>(userService.getBalance(id), HttpStatus.OK);
    }
}
