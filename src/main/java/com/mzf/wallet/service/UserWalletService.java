package com.mzf.wallet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mzf.wallet.entity.UserWallet;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface UserWalletService extends IService<UserWallet> {

    /**
     *  查询用户钱包余额
     * @param userId
     * @return balance
     */
    BigDecimal getBalance(Integer userId);

    /**
     *  消费
     * @param userId
     * @param amount
     * @return 消费成功/失败
     */
    Boolean consume(Integer userId , String amount);

    /**
     *  退款
     * @param userId
     * @param amount
     * @return
     */
    Boolean refund(Integer userId , String amount);

}
