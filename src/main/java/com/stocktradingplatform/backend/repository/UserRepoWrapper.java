package com.stocktradingplatform.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stocktradingplatform.backend.bean.UserBean;
import com.stocktradingplatform.backend.entity.UserEntity;

@Repository
public class UserRepoWrapper {

    private final UserRepo userRepo;

    public UserRepoWrapper(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserBean> getUserDetails(String email){

        List<UserEntity> userEntities = new ArrayList<>();
        List<UserBean> userBeans = new ArrayList<>();

        try {
            userEntities = userRepo.findByEmail(email);
            if(userEntities.isEmpty())
                throw new Exception("Email Id not found");
            userEntities.forEach(userEntity->{
                UserBean userBean = new UserBean();

                userBean.setEmail(userEntity.getEmail());
                userBean.setFirstName(userEntity.getFirstName());
                userBean.setLastName(userEntity.getLastName());
                userBean.setBalance(userEntity.getBalance());

                userBeans.add(userBean);

            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return userBeans;
    }

}
