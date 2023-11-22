package com.stocktradingplatform.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> addMoneyToWallet(Float balance){

        return null;
    }
}
