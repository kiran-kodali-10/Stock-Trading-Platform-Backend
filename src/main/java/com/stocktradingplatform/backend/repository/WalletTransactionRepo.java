package com.stocktradingplatform.backend.repository;

import com.stocktradingplatform.backend.bean.UserBean;
import com.stocktradingplatform.backend.entity.WalletTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface WalletTransactionRepo extends JpaRepository<WalletTransactionEntity, Long> {
    List<WalletTransactionEntity> findByUid(Integer id);
}
