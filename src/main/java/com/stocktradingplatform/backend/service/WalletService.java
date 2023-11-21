package com.stocktradingplatform.backend.service;

import java.util.List;

import com.stocktradingplatform.backend.bean.WalletTransactionBean;

public interface WalletService {
    List<WalletTransactionBean> getAllWalletTransactions(Integer id);
}
