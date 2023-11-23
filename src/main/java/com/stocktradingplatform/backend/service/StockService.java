package com.stocktradingplatform.backend.service;

import com.stocktradingplatform.backend.bean.StockBean;
import com.stocktradingplatform.backend.bean.StockTransactionBean;
import com.stocktradingplatform.backend.entity.StockEntity;
import com.stocktradingplatform.backend.entity.StockTransactionEntity;
import com.stocktradingplatform.backend.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {
    List<StockBean> getAllStockData();
    List<StockBean> getStockData (String symbol);

    List<StockTransactionBean> getAllTransactions(Integer id);

    StockTransactionBean buySellStocks(StockTransactionBean stockTransactionBean);
}
