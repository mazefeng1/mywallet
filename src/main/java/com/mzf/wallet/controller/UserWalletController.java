package com.mzf.wallet.controller;

import com.mzf.wallet.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author 好大雨
 * @create 2023/3/27 15:39
 */
@RestController
@RequestMapping("/wallet")
public class UserWalletController {

    @Autowired
    private UserWalletService userWalletService;

    /**
     *  查询用户钱包余额
     * @param userId
     * @return  balance
     */
    @GetMapping("/getBalance")
    public BigDecimal getBalance(@RequestParam("userId") Integer userId){
        BigDecimal balance = userWalletService.getBalance(userId);
        return balance;
    }

    /**
     *      用户消费
     * @param userId
     * @param amount    消费金额
     * @return 消费是否成功
     */
    @PostMapping("/consume")
    public String consume(@RequestParam("userId") Integer userId,
                          @RequestParam("amount") String amount){
        return userWalletService.consume(userId,amount)?"消费成功":"消费失败";
    }

    /**
     *      给用户退款
     * @param userId
     * @param amount    退款金额
     * @return 退款是否成功
     */
    @PostMapping("/refund")
    public String refund(@RequestParam("userId") Integer userId,
                         @RequestParam("amount") String amount){
        return userWalletService.refund(userId,amount)?"退款成功":"退款失败";
    }
}
