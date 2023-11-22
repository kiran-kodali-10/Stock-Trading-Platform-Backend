package com.stocktradingplatform.backend.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.stocktradingplatform.backend.bean.LoginCredentials;
import com.stocktradingplatform.backend.bean.UserRegister;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.stocktradingplatform.backend.bean.UserBean;
import com.stocktradingplatform.backend.entity.UserEntity;

import static com.stocktradingplatform.backend.service.UserServiceImpl.encodeToBase64;

@Repository
public class UserRepoWrapper {

    @Autowired
    UserRepo userRepo;

    public List<UserBean> getUserDetails(String email) {
        List<UserEntity> userEntities;
        List<UserBean> userBeans = new ArrayList<>();
        try {
            userEntities = userRepo.findByEmail(email);
            if(userEntities.isEmpty())
                throw new Exception("Email Id not found");
            setUserBeans(userEntities, userBeans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userBeans;
    }

    public List<UserBean> getAllUsers() {
        List<UserEntity> userEntities;
        List<UserBean> userBeans = new ArrayList<>();
        try {
            userEntities = userRepo.findAll();
            setUserBeans(userEntities, userBeans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return userBeans;
    }

    public List<UserBean> getUserById(Integer id) {
        List<UserEntity> userEntities;
        List<UserBean> userBeans = new ArrayList<>();
        try {
            userEntities = userRepo.findByUid(id);
            setUserBeans(userEntities, userBeans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userBeans;
    }

    public void createUser(UserRegister userRegister) {
        List<UserEntity> userEntities;
        UserEntity user = new UserEntity();

        try {
            userEntities = userRepo.findByEmail(userRegister.getEmail());
            if(userEntities.isEmpty()) {
                System.out.println("User not found");
                user.setFirstName(userRegister.getFirstName());
                user.setLastName(userRegister.getLastName());
                user.setUsername(userRegister.getUserName());
                user.setEmail(userRegister.getEmail());
                user.setPhone(userRegister.getPhone());
                user.setBalance(BigDecimal.valueOf(0.00));
                user.setRole("USER");
                user.setPasswordHash(encodeToBase64(encodeToBase64(userRegister.getPassword())));
            }
            userRepo.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void updateUserBalance(Integer id, BigDecimal balance, String status) {
        List<UserEntity> userEntities = userRepo.findByUid(id);

        if (!userEntities.isEmpty()) {
            if (status.equals("LOAD") || status.equals("SELL")) {
                userEntities.get(0).setBalance(balance);
                userRepo.save(userEntities.get(0));
            } else if (status.equals("BUY") || status.equals("WITHDRAW")) {
                BigDecimal absoluteValue = balance.abs();
                userEntities.get(0).setBalance(absoluteValue);
                userRepo.save(userEntities.get(0));
            }
        }
    }

    public List<UserBean> getUserByEmailAndPassword(String email, String password) {
        List<UserEntity> userEntities;
        List<UserBean> userBeans = new ArrayList<>();
        try {
            userEntities = userRepo.findByEmailAndPasswordHash(email, password);
            if (userEntities.isEmpty()) {
                throw new Exception("Email or Password incorrect");
            }
            setUserBeans(userEntities, userBeans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userBeans;
    }

    private void setUserBeans(List<UserEntity> userEntities, List<UserBean> userBeans) {
        userEntities.forEach(userEntity->{
            UserBean userBean = new UserBean();
            userBean.setId(userEntity.getUid());
            userBean.setEmail(userEntity.getEmail());
            userBean.setFirstName(userEntity.getFirstName());
            userBean.setLastName(userEntity.getLastName());
            userBean.setBalance(userEntity.getBalance());
            userBeans.add(userBean);
        });
    }

}
