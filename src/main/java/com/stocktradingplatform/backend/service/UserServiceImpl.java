package com.stocktradingplatform.backend.service;

import java.util.Base64;
import java.util.List;

import com.stocktradingplatform.backend.bean.LoginCredentials;
import com.stocktradingplatform.backend.bean.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktradingplatform.backend.bean.UserBean;
import com.stocktradingplatform.backend.repository.UserRepoWrapper;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepoWrapper userRepo;

    @Override
    public List<UserBean> getUserDetails(String email) {
        return userRepo.getUserDetails(email);
    }

    @Override
    public List<UserBean> getUserById(Integer id) {
        return userRepo.getUserById(id);
    }

    @Override
    public List<UserBean> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @Override
    public void createUser(UserRegister user) {
        System.out.println("User Service: " + user.getEmail());
        userRepo.createUser(user);
    }

    public List<UserBean> loginUser(LoginCredentials loginCredentials) {
        String email = loginCredentials.getEmail();
        String password = loginCredentials.getPassword();
        System.out.println(email + " : " + password);

        return userRepo.getUserByEmailAndPassword(email, encodeToBase64(encodeToBase64(password)));
    }

    public static String encodeToBase64(String originalString) {
        byte[] bytes = originalString.getBytes();
        byte[] encodedBytes = Base64.getEncoder().encode(bytes);
        return new String(encodedBytes);
    }

//    public static String decodeFromBase64(String encodedString) {
//        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//        return new String(decodedBytes);
//    }
}
