package com.stocktradingplatform.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stocktradingplatform.backend.entity.UserEntity;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    // @Query("SELECT U FROM STOCK_TRADING.USERS U WHERE U.EMAIL = :email")
    // List<UserEntity> findUserByEmail(@Param("email") String email);

    List<UserEntity> findByEmail(String email);

}
