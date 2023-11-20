package com.stocktradingplatform.backend.repository;

import com.stocktradingplatform.backend.entity.StockEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepo extends JpaRepository<StockEntity, String> {
    List<StockEntity> findBySymbol(String symbol);
}
