package com.stocktradingplatform.backend.controller;

import java.util.List;

import com.stocktradingplatform.backend.bean.WalletTransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stocktradingplatform.backend.bean.WalletTransactionBean;
import com.stocktradingplatform.backend.service.WalletServiceImpl;

@RestController
@RequestMapping("/api/wallet")
public class WalletTransactionController {

    @Autowired
    WalletServiceImpl walletService;

    @GetMapping("/walletTransactions")
    public ResponseEntity<List<WalletTransactionBean>> getWalletTransactions(@RequestParam Integer id) {
        return new ResponseEntity<>(walletService.getAllWalletTransactions(id), HttpStatus.OK);
    }

    @PostMapping("/addMoney")
    public ResponseEntity<WalletTransactionBean> addMoneyToWallet(@RequestBody WalletTransactionRequest transactionRequest){
        return new ResponseEntity<>(walletService.addMoneyToWallet(transactionRequest), HttpStatus.OK);
    }
}
