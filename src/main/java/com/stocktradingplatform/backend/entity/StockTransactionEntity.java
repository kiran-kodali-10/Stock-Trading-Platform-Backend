package com.stocktradingplatform.backend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "STOCK_TXN")
public class StockTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UID", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "SYMBOL", nullable = false)
    private StockEntity stock;

    @Column(name = "BUY_SELL", nullable = false)
    private String buySell;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "MODE")
    private String mode;

    @Column(name = "TIMESTAMP")
    private Timestamp timestamp;

    @Column(name="QUANTITY")
    private BigDecimal quantity;

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

    public StockEntity getStock() {
        return stock;
    }

    public void setStock(StockEntity stock) {
        this.stock = stock;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
