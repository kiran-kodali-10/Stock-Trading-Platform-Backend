package com.stocktradingplatform.backend.service;

import com.stocktradingplatform.backend.bean.StockBean;
import com.stocktradingplatform.backend.bean.StockTransactionBean;
import com.stocktradingplatform.backend.bean.WalletTransactionRequest;
import com.stocktradingplatform.backend.repository.StockRepoWrapper;
import com.stocktradingplatform.backend.repository.StockTransactionRepo;
import com.stocktradingplatform.backend.repository.StockTransactionRepoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepoWrapper stockRepo;

    @Autowired
    StockTransactionRepoWrapper stockTransactionRepo;

    @Override
    public List<StockBean> getAllStockData () {
        return stockRepo.getAllStockData();
    }

    @Override
    public List<StockBean> getStockData (String symbol) {
        return stockRepo.getStockData(symbol);
    }

    public List<StockTransactionBean> getAllTransactions(Integer id) {
        return stockTransactionRepo.getAllTransactions(id);
    }

    public StockTransactionBean buySellStocks(StockTransactionBean stockTransactionBean) {
        return stockTransactionRepo.buySellStocks(stockTransactionBean);
    }
}

