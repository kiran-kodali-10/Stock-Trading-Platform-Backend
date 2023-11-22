package com.stocktradingplatform.backend.service;

import java.util.List;

import com.stocktradingplatform.backend.bean.WalletTransactionBean;
import com.stocktradingplatform.backend.bean.WalletTransactionRequest;

public interface WalletService {
    List<WalletTransactionBean> getAllWalletTransactions(Integer id);

    WalletTransactionBean addMoneyToWallet(WalletTransactionRequest transactionRequest);
}
