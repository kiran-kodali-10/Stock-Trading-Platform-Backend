package com.stocktradingplatform.backend.service;

import com.stocktradingplatform.backend.bean.StockBean;
import com.stocktradingplatform.backend.entity.StockEntity;
import com.stocktradingplatform.backend.entity.StockTransactionEntity;
import com.stocktradingplatform.backend.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {
    List<StockBean> getAllStockData();
    List<StockBean> getStockData (String symbol);
}

//    void buyStock(UserEntity user, String symbol, int quantity, double price);
//    void sellStock(UserEntity user, String symbol, int quantity, double price);
//    List<StockTransaction> getUserTransactions(UserEntity user);