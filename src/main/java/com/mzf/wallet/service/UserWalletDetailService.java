package com.mzf.wallet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mzf.wallet.entity.UserWalletDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserWalletDetailService extends IService<UserWalletDetail> {

    /**
     *  查询用户钱包金额变动明细
     * @param userId
     * @return 消费明细List集合
     */
    List<UserWalletDetail> getDetails(Integer userId);
}
