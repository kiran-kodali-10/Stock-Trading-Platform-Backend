package com.stocktradingplatform.backend.service;

import java.util.List;

import com.stocktradingplatform.backend.bean.UserBean;

public interface UserService {
    List<UserBean> getUserDetails(String email);
    List<UserBean> getUserById(Long id);

    void createUser(UserBean user);


}
