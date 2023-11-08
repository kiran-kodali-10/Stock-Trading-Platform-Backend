SELECT SCHEMA_NAME
  FROM INFORMATION_SCHEMA.SCHEMATA
 WHERE SCHEMA_NAME = 'STOCK_TRADING';

CREATE DATABASE STOCK_TRADING;

USE STOCK_TRADING;

CREATE TABLE USERS (
    UID INT NOT NULL AUTO_INCREMENT,
    FIRST_NAME VARCHAR(128),
    LAST_NAME VARCHAR(128) NOT NULL ,
    USERNAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(50),
    PHONE VARCHAR(15),
    SSN VARCHAR(12),
    VERIFIED ENUM('Y','N') DEFAULT 'N',
    MEMBER_SINCE DATE,
    ROLE VARCHAR(20) NOT NULL DEFAULT 'USER',
    PASSWORD_HASH VARCHAR(250),
    TOKEN VARCHAR(128),
    LAST_UPDATE_DATE DATETIME,
    BALANCE DECIMAL(20,2) DEFAULT 0.00,
    PRIMARY KEY(UID)
);

CREATE TABLE STOCKS (
    SYMBOL VARCHAR(6) NOT NULL,
    DATE DATE,
    TIME TIME,
    OPEN DECIMAL(20,2),
    CLOSE DECIMAL(20,2),
    HIGH DECIMAL(20,2),
    LOW DECIMAL(20,2),
    VOLUME INT,
    PRIMARY KEY(SYMBOL)
);

CREATE TABLE STOCK_TXN (
    TID INT NOT NULL AUTO_INCREMENT,
    UID INT NOT NULL,
    SYMBOL VARCHAR(6) NOT NULL,
    BUY_SELL VARCHAR(4) NOT NULL,
    STATUS VARCHAR(10),
    MODE VARCHAR(20),
    TIMESTAMP TIMESTAMP,
    PRIMARY KEY (TID),
    CONSTRAINT FK_USERS FOREIGN KEY (UID) REFERENCES USERS(UID),
    CONSTRAINT FK_STOCKS FOREIGN KEY (SYMBOL) REFERENCES STOCKS(SYMBOL)
);

CREATE TABLE WALLET_TXN (
    WID INT NOT NULL AUTO_INCREMENT,
    UID INT NOT NULL,
    PREVIOUS_BALANCE DECIMAL(20,2),
    AMOUNT DECIMAL(20,2),
    STATUS VARCHAR(10),
    METHOD VARCHAR(20),
    TAXES DECIMAL(12,2),
    FEES DECIMAL(12,2),
    PRIMARY KEY(WID),
    CONSTRAINT FK_WALLET_USERS FOREIGN KEY(UID) REFERENCES USERS(UID)
);

