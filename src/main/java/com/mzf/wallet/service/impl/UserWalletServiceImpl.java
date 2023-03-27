package com.mzf.wallet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mzf.wallet.entity.UserWallet;
import com.mzf.wallet.entity.UserWalletDetail;
import com.mzf.wallet.mapper.UserWalletDetailMapper;
import com.mzf.wallet.mapper.UserWalletMapper;
import com.mzf.wallet.service.UserWalletDetailService;
import com.mzf.wallet.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


/**
 * @author 好大雨
 * @create 2023/3/27 15:29
 */
@Service
public class UserWalletServiceImpl extends ServiceImpl<UserWalletMapper, UserWallet> implements UserWalletService {

    @Autowired
    UserWalletMapper userWalletMapper;

    @Autowired
    UserWalletDetailMapper userWalletDetailMapper;

    /**
     * 查询用户钱包余额
     * @param userId
     * @return balance
     */
    @Override
    public BigDecimal getBalance(Integer userId) {
        UserWallet userWallet = userWalletMapper.selectOne(new QueryWrapper<UserWallet>().eq("user_id",userId) );
        return userWallet.getBalance();
    }

    /**
     *  用户消费
     * @param userId
     * @param amount
     * @return
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public Boolean consume(Integer userId, String amount) {
        //1.查询余额
        UserWallet userWallet = this.getOne(new QueryWrapper<UserWallet>().eq("user_id",userId));

        //2.扣费并校验余额
        BigDecimal decimal = userWallet.getBalance().subtract(new BigDecimal(amount));
        if(decimal.compareTo(BigDecimal.ZERO) == -1){
            //余额不足，消费失败
            throw new RuntimeException("余额不足");
        }

        //3.扣余额

        userWallet.setBalance(decimal);
        boolean flag = this.updateById(userWallet);
        if(flag){
            //更新失败
            throw new RuntimeException("扣费失败");
        }
        //4.添加交易记录
        UserWalletDetail userWalletDetail = new UserWalletDetail();
        userWalletDetail.setUserId(userId);
        userWalletDetail.setTradeAmount(new BigDecimal(amount));
        userWalletDetail.setTradeType(0);           //0:扣费

        int flag1 = userWalletDetailMapper.insert(userWalletDetail);
        if(flag1==0){
            throw  new RuntimeException("添加扣费记录失败");
        }
        return true;
    }

    @Override
    public Boolean refund(Integer userId, String amount) {
        //1.查询余额
        UserWallet userWallet = this.getOne(new QueryWrapper<UserWallet>().eq("user_id",userId));

        //2.添加余额
        BigDecimal decimal = userWallet.getBalance().add(new BigDecimal(amount));

        userWallet.setBalance(decimal);
        boolean flag = this.updateById(userWallet);
        if(flag){
            //更新失败
            throw new RuntimeException("扣费失败");
        }
        //4.添加交易记录
        UserWalletDetail userWalletDetail = new UserWalletDetail();
        userWalletDetail.setUserId(userId);
        userWalletDetail.setTradeAmount(new BigDecimal(amount));
        userWalletDetail.setTradeType(1);           //0:充值/退款

        int flag1 = userWalletDetailMapper.insert(userWalletDetail);
        if(flag1==0){
            throw  new RuntimeException("添加充值或退款记录失败");
        }

        return true;
    }
}
