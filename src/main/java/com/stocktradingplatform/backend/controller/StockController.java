package com.stocktradingplatform.backend.controller;


import com.stocktradingplatform.backend.bean.StockTransactionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stocktradingplatform.backend.bean.StockBean;
import com.stocktradingplatform.backend.service.StockService;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    StockService stockService;
    @GetMapping("/all")
    public ResponseEntity<List<StockBean>> getAllStocks() {
        return new ResponseEntity<>(stockService.getAllStockData(), HttpStatus.OK);
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<List<StockBean>> getStockData(@PathVariable String symbol) {
        return new ResponseEntity<>(stockService.getStockData(symbol), HttpStatus.OK);
    }

    @PostMapping("/buy")
    public ResponseEntity<StockTransactionBean> buyStock(@RequestBody StockTransactionBean stockTransactionBean){
        return new ResponseEntity<>(stockService.buySellStocks(stockTransactionBean), HttpStatus.OK);
    }

    @PostMapping("/sell")
    public ResponseEntity<StockTransactionBean> sellStock(@RequestBody StockTransactionBean stockTransactionBean){
        return new ResponseEntity<>(stockService.buySellStocks(stockTransactionBean), HttpStatus.OK);
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<List<StockTransactionBean>> getStockTransactions(@PathVariable Integer id) {
        return new ResponseEntity<>(stockService.getAllTransactions(id), HttpStatus.OK);
    }
}
