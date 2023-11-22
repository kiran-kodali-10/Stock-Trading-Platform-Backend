package com.stocktradingplatform.backend.service;

import java.math.BigDecimal;
import java.util.List;

import com.stocktradingplatform.backend.bean.LoginCredentials;
import com.stocktradingplatform.backend.bean.UserBean;
import com.stocktradingplatform.backend.bean.UserRegister;

public interface UserService {
    List<UserBean> getUserDetails(String email);

    List<UserBean> getUserById(Integer id);

    List<UserBean> getAllUsers();

    void createUser(UserRegister user);

    List<UserBean> loginUser(LoginCredentials loginCredentials);

    void updateUserBalance(Integer id, BigDecimal balance, String status);

    BigDecimal getBalance(Integer id);
    
}
