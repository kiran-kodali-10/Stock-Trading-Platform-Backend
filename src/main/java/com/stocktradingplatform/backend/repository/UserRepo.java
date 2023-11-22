package com.stocktradingplatform.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktradingplatform.backend.entity.UserEntity;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByEmail(String email);
    List<UserEntity> findByUid(Integer id);
    List<UserEntity> findByEmailAndPasswordHash(String email, String passwordHash);

}
