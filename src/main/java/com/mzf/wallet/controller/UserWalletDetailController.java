package com.mzf.wallet.controller;

import com.mzf.wallet.entity.UserWalletDetail;
import com.mzf.wallet.service.UserWalletDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 好大雨
 * @create 2023/3/27 15:39
 */
@RestController
@RequestMapping("/detail")
public class UserWalletDetailController {

    @Autowired
    private UserWalletDetailService userWalletDetailService;

    @GetMapping("/getDetails")
    public List<UserWalletDetail> getDetails(@RequestParam("userId") Integer userId){
        return userWalletDetailService.getDetails(userId);
    }
}
