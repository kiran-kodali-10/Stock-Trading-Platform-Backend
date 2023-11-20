package com.stocktradingplatform.backend.service;

import com.stocktradingplatform.backend.entity.StockEntity;
import com.stocktradingplatform.backend.entity.StockTransaction;
import com.stocktradingplatform.backend.entity.UserEntity;

import java.util.List;

public interface StockService {
    StockEntity getStockData(String symbol);
    
//    List<NewsArticle> getStockNews(String symbol);
    void buyStock(UserEntity user, String symbol, int quantity, double price);
    void sellStock(UserEntity user, String symbol, int quantity, double price);
    List<StockTransaction> getUserTransactions(UserEntity user);


}
