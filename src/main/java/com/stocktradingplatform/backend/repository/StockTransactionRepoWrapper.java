package com.stocktradingplatform.backend.repository;

import org.springframework.stereotype.Repository;

import com.stocktradingplatform.backend.bean.StockTransactionBean;
import com.stocktradingplatform.backend.entity.StockTransactionEntity;

@Repository
public class StockTransactionRepoWrapper {

    public String insertStockTransaction(StockTransactionBean stockTransactionBean) {
        StockTransactionEntity stockTransactionEntity = new StockTransactionEntity();
        try {
            // stockTransactionEntity.(stockTransactionBean.getMode());
            stockTransactionEntity.setBuySell(stockTransactionBean.getBuySell());
            stockTransactionEntity.setStatus(stockTransactionBean.getStatus());
            stockTransactionEntity.setMode(stockTransactionBean.getMode());
            stockTransactionEntity.setTimestamp(stockTransactionBean.getTimestamp());

        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }
}
