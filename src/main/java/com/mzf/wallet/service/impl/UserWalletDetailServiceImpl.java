package com.mzf.wallet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mzf.wallet.entity.UserWalletDetail;
import com.mzf.wallet.mapper.UserWalletDetailMapper;
import com.mzf.wallet.service.UserWalletDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 好大雨
 * @create 2023/3/27 15:29
 */
@Service
public class UserWalletDetailServiceImpl extends ServiceImpl<UserWalletDetailMapper,UserWalletDetail> implements UserWalletDetailService {
    @Autowired
    UserWalletDetailMapper userWalletDetailMapper;

    @Override
    public List<UserWalletDetail> getDetails(Integer userId) {
        return userWalletDetailMapper.selectList(new QueryWrapper<UserWalletDetail>().eq("user_id",userId));
    }
}
