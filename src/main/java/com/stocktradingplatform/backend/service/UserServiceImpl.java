package com.stocktradingplatform.backend.service;

import java.util.List;

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
    
}
