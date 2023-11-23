package com.stocktradingplatform.backend.repository;

import com.stocktradingplatform.backend.bean.UserBean;
import com.stocktradingplatform.backend.bean.WalletTransactionRequest;
import com.stocktradingplatform.backend.service.UserService;
import com.stocktradingplatform.backend.service.WalletService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stocktradingplatform.backend.bean.StockTransactionBean;
import com.stocktradingplatform.backend.entity.StockTransactionEntity;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StockTransactionRepoWrapper {

    @Autowired
    StockTransactionRepo stockTransactionRepo;

    @Autowired
    UserService userService;

    @Autowired
    WalletService walletService;

    public StockTransactionBean buySellStocks(StockTransactionBean stockTransactionBean) {
        StockTransactionEntity stockTransactionEntity = new StockTransactionEntity();
        try {
            BeanUtils.copyProperties(stockTransactionBean, stockTransactionEntity);
            StockTransactionEntity saveTransaction = stockTransactionRepo.save(stockTransactionEntity);
            stockTransactionBean.setTid(saveTransaction.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stockTransactionBean;
    }

    public List<StockTransactionBean> getAllTransactions(Integer id) {
        List<StockTransactionEntity> stockTransactions;
        List<StockTransactionBean> stockTransactionBeans = new ArrayList<>();
        List<UserBean> userBeans = userService.getUserById(id);
        try {
            if (userBeans.isEmpty()) {
                throw new RuntimeException("User not found..");
            }
            stockTransactions = stockTransactionRepo.findByUid(id);

            if (!stockTransactions.isEmpty()) {
                stockTransactions.forEach(stockTransaction -> {
                    StockTransactionBean stockBean = new StockTransactionBean();
                    stockBean.setTid(stockTransaction.getId());
                    BeanUtils.copyProperties(stockTransaction, stockBean);
                    stockTransactionBeans.add(stockBean);
                });
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return stockTransactionBeans;
    }
}
