package com.stocktradingplatform.backend.repository;

import com.stocktradingplatform.backend.bean.StockBean;
import com.stocktradingplatform.backend.bean.UserBean;
import com.stocktradingplatform.backend.entity.StockEntity;
import com.stocktradingplatform.backend.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StockRepoWrapper {

    @Autowired
    StockRepo stockRepo;

    public List<StockBean> getAllStockData() {
        List<StockEntity> stockEntity;
        List<StockBean> stockBeans = new ArrayList<>();
        try {
            stockEntity = stockRepo.findAll();
            setStockBeans(stockEntity, stockBeans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stockBeans;
    }

    public List<StockBean> getStockData(String symbol) {
        List<StockEntity> stockEntity;
        List<StockBean> stockBeans = new ArrayList<>();
        try {
            stockEntity = stockRepo.findBySymbol(symbol);
            setStockBeans(stockEntity, stockBeans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stockBeans;
    }

    private void setStockBeans(List<StockEntity> stockEntities, List<StockBean> stockBeans) {
        stockEntities.forEach(stockEntity -> {
            StockBean stock = new StockBean();
            stock.setSymbol(stockEntity.getSymbol());
            stock.setDate(stockEntity.getDate());
            stock.setClose(stockEntity.getClose());
            stock.setOpen(stockEntity.getOpen());
            stock.setHigh(stockEntity.getHigh());
            stock.setLow(stockEntity.getLow());
            stock.setVolume(stockEntity.getVolume());
            stock.setTime(stockEntity.getTime());

            stockBeans.add(stock);
        });
    }
}
