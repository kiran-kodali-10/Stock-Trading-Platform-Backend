package com.stocktradingplatform.backend.service;

import com.stocktradingplatform.backend.bean.StockBean;
import com.stocktradingplatform.backend.repository.StockRepoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepoWrapper stockRepo;

    @Override
    public List<StockBean> getAllStockData () {
        return stockRepo.getAllStockData();
    }

    @Override
    public List<StockBean> getStockData (String symbol) {
        return stockRepo.getStockData(symbol);
    }
}

