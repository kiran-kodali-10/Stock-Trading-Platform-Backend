package com.stocktradingplatform.backend.repository;

import com.stocktradingplatform.backend.entity.StockTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTransactionRepo extends JpaRepository<StockTransactionEntity, Long> {
}
