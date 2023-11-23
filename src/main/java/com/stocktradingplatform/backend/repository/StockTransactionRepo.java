package com.stocktradingplatform.backend.repository;

import com.stocktradingplatform.backend.bean.StockTransactionBean;
import com.stocktradingplatform.backend.entity.StockTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockTransactionRepo extends JpaRepository<StockTransactionEntity, Integer> {
    List<StockTransactionEntity> findByUid(Integer uid);
}
