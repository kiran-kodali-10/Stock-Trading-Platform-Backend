package com.stocktradingplatform.backend.repository;

import com.stocktradingplatform.backend.entity.StockEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<StockEntity, String> {

}
