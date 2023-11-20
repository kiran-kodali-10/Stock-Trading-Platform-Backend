package com.stocktradingplatform.backend.repository;

import com.stocktradingplatform.backend.entity.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTransactionRepo extends JpaRepository<WalletTransaction, Long> {
}
