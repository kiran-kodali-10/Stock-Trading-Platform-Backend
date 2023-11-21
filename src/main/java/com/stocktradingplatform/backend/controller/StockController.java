package com.stocktradingplatform.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktradingplatform.backend.bean.StockBean;
import com.stocktradingplatform.backend.bean.WalletTransactionBean;
import com.stocktradingplatform.backend.service.StockService;
import com.stocktradingplatform.backend.service.WalletService;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    StockService stockService;

    @Autowired
    WalletService walletService;

    @GetMapping("/all")
    public ResponseEntity<List<StockBean>> getAllStocks() {
        return new ResponseEntity<>(stockService.getAllStockData(), HttpStatus.OK);
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<List<StockBean>> getStockData(@PathVariable String symbol) {
        return new ResponseEntity<>(stockService.getStockData(symbol), HttpStatus.OK);
    }

    @GetMapping("/walletTransactions")
    public ResponseEntity<List<WalletTransactionBean>> buyStock(@PathVariable Integer id){
        
        return new ResponseEntity<>(walletService.getAllWalletTransactions(id), HttpStatus.OK);
    }
}
