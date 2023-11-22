package com.stocktradingplatform.backend.bean;

import java.math.BigDecimal;

public class WalletTransactionBean {
    private Integer wid;
    private Integer uid;
    private BigDecimal previousBalance;
    private BigDecimal amount;
    private String status;
    private String method;
    private BigDecimal taxes;
    private BigDecimal fees;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    public BigDecimal getPreviousBalance() {
        return previousBalance;
    }
    public void setPreviousBalance(BigDecimal previousBalance) {
        this.previousBalance = previousBalance;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public BigDecimal getTaxes() {
        return taxes;
    }
    public void setTaxes(BigDecimal taxes) {
        this.taxes = taxes;
    }
    public BigDecimal getFees() {
        return fees;
    }
    public void setFees(BigDecimal fees) {
        this.fees = fees;
    }

    
}
