package com.stocktradingplatform.backend.service;

import com.stocktradingplatform.backend.bean.StockBean;
import com.stocktradingplatform.backend.repository.StockRepoWrapper;

import java.util.List;

public class StockServiceImpl {

    StockRepoWrapper stockRepo;

    public List<StockBean> getStockData () {
        return stockRepo.getAllStockData();
    }

    public List<StockBean> getStockData (String symbol) {
        return stockRepo.getStockData(symbol);
    }
}

