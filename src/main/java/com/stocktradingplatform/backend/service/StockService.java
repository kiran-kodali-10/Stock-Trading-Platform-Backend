package com.stocktradingplatform.backend.service;

import com.stocktradingplatform.backend.bean.StockBean;
import com.stocktradingplatform.backend.entity.StockEntity;
import com.stocktradingplatform.backend.entity.StockTransaction;
import com.stocktradingplatform.backend.entity.UserEntity;

import java.util.List;

public interface StockService {
    List<StockBean> getStockData();
    List<StockBean> getStockData (String symbol);
}

//    void buyStock(UserEntity user, String symbol, int quantity, double price);
//    void sellStock(UserEntity user, String symbol, int quantity, double price);
//    List<StockTransaction> getUserTransactions(UserEntity user);