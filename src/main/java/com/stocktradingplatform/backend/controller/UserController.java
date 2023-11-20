package com.stocktradingplatform.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity<List<UserBean>> getUserById(Long id) {
        System.out.println(id);
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<List<UserBean>> login(@RequestBody LoginCredentials loginCredentials) {
        String email = loginCredentials.getEmail();
        String password = loginCredentials.getPassword();

        List<UserBean> userBeanList = userService.getUserDetails(email);
        System.out.println(userBeanList.get(0).getEmail());
        if (userBeanList.get(0).getEmail().equals(email)) {
            return new ResponseEntity<>(userBeanList, HttpStatus.OK);
        }

            return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
