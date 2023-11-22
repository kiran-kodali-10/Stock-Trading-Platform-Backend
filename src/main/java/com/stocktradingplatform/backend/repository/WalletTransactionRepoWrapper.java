package com.stocktradingplatform.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stocktradingplatform.backend.bean.WalletTransactionBean;
import com.stocktradingplatform.backend.entity.UserEntity;
import com.stocktradingplatform.backend.entity.WalletTransactionEntity;

@Repository
public class WalletTransactionRepoWrapper {

    @Autowired
    WalletTransactionRepo walletTransactionRepo;

    @Autowired
    UserRepo userRepo;
    
    public List<WalletTransactionBean> getAllTransactionForUser(Integer id){
        List<WalletTransactionEntity> walletTransactionEntities = new ArrayList<>();
        List<WalletTransactionBean> walletTransactionBeans = new ArrayList<>();
        System.out.println("inside wallet transaction repo wrapper");
        try {
            List<UserEntity> userEntity = userRepo.findByUid(id);
            System.out.println(userEntity.get(0).getEmail());
            walletTransactionEntities = walletTransactionRepo.findByUser(userEntity.get(0));
            walletTransactionEntities.forEach(walletTransactionEntity ->{
                WalletTransactionBean walletTransactionBean = new WalletTransactionBean();
                BeanUtils.copyProperties(walletTransactionEntity, walletTransactionBean);
                walletTransactionBeans.add(walletTransactionBean);
            });
            return walletTransactionBeans;
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

    public List<WalletTransactionBean> addMoneyToWallet(Float balance){

        List<WalletTransactionBean> listTransactionBeans = new ArrayList<>();
        List<WalletTransactionEntity> listTransactionEntity = new ArrayList<>();

        WalletTransactionEntity transactionEntity = new WalletTransactionEntity();

        listTransactionBeans = getAllTransactionForUser(null);

        try {
            transactionEntity.setAmount(null);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

}
