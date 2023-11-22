package com.stocktradingplatform.backend.service;

import java.util.List;

import com.stocktradingplatform.backend.bean.WalletTransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktradingplatform.backend.bean.WalletTransactionBean;
import com.stocktradingplatform.backend.repository.WalletTransactionRepoWrapper;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletTransactionRepoWrapper walletTransactionRepo;

    @Override
    public List<WalletTransactionBean> getAllWalletTransactions(Integer id) {
        return walletTransactionRepo.getAllTransactionForUser(id);
    }

    @Override
    public WalletTransactionBean addMoneyToWallet(WalletTransactionRequest transactionRequest) {
        return walletTransactionRepo.addMoneyToWallet(transactionRequest);
    }
    
}
