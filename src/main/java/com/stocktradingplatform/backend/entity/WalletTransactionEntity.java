package com.stocktradingplatform.backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "WALLET_TXN")
public class WalletTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UID", nullable = false)
    private UserEntity user;

    @Column(name = "PREVIOUS_BALANCE")
    private BigDecimal previousBalance;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "METHOD")
    private String method;

    @Column(name = "TAXES")
    private BigDecimal taxes;

    @Column(name = "FEES")
    private BigDecimal fees;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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
