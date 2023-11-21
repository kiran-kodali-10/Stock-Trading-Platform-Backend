package com.stocktradingplatform.backend.repository;

import com.stocktradingplatform.backend.entity.UserEntity;
import com.stocktradingplatform.backend.entity.WalletTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface WalletTransactionRepo extends JpaRepository<WalletTransactionEntity, Long> {
    List<WalletTransactionEntity> findByUser(UserEntity user);
}
