package com.stocktradingplatform.backend.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.stocktradingplatform.backend.bean.UserBean;
import com.stocktradingplatform.backend.bean.WalletTransactionRequest;
import com.stocktradingplatform.backend.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stocktradingplatform.backend.bean.WalletTransactionBean;
import com.stocktradingplatform.backend.entity.WalletTransactionEntity;

@Repository
public class WalletTransactionRepoWrapper {

    @Autowired
    WalletTransactionRepo walletTransactionRepo;

    @Autowired
    UserService userService;
    
    public List<WalletTransactionBean> getAllTransactionForUser(Integer id){
        List<WalletTransactionEntity> walletTransactionEntities;
        List<WalletTransactionBean> walletTransactionBeans = new ArrayList<>();
        System.out.println("inside wallet transaction repo wrapper");
        try {
            UserBean userBean = getUser(id);
            System.out.println(userBean.getEmail());

            walletTransactionEntities = walletTransactionRepo.findByUid(userBean.getId());

            if (!walletTransactionEntities.isEmpty()) {
                walletTransactionEntities.forEach(walletTransactionEntity -> {
                    WalletTransactionBean walletTransactionBean = new WalletTransactionBean();
                    walletTransactionBean.setWid(walletTransactionEntity.getId());
                    BeanUtils.copyProperties(walletTransactionEntity, walletTransactionBean);
                    walletTransactionBeans.add(walletTransactionBean);
                });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return walletTransactionBeans;
    }

    public WalletTransactionBean addMoneyToWallet(WalletTransactionRequest walletTransactionRequest){
        WalletTransactionEntity transactionEntity = new WalletTransactionEntity();
        WalletTransactionBean walletTransactionBean = new WalletTransactionBean();
        try {
            UserBean userBean = getUser(walletTransactionRequest.getUserId());
            System.out.println(userBean.getEmail() + " : " + userBean.getId());

            transactionEntity.setUid(userBean.getId());
            transactionEntity.setAmount(walletTransactionRequest.getAmount());
            transactionEntity.setFees(walletTransactionRequest.getFees());
            transactionEntity.setMethod(walletTransactionRequest.getMethod());
            transactionEntity.setPreviousBalance(userBean.getBalance());
            transactionEntity.setStatus(walletTransactionRequest.getStatus());
            transactionEntity.setTaxes(walletTransactionRequest.getTaxes());

            BigDecimal balance = userBean.getBalance();
            BigDecimal newBalance = balance.add(walletTransactionRequest.getAmount());

            WalletTransactionEntity saveTransaction = walletTransactionRepo.save(transactionEntity);
            BeanUtils.copyProperties(saveTransaction, walletTransactionBean);

            userService.updateUserBalance(transactionEntity.getUid(), newBalance, walletTransactionRequest.getStatus());

            walletTransactionBean.setWid(saveTransaction.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return walletTransactionBean;
    }

    public UserBean getUser(Integer id) {
        List<UserBean> userBeans = userService.getUserById(id);
        if(userBeans.isEmpty()) {
            throw new RuntimeException("User Not found..");
        }
        return userBeans.get(0);
    }

}
