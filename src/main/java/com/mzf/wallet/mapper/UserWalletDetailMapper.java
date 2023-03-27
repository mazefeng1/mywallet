package com.mzf.wallet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mzf.wallet.entity.UserWalletDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWalletDetailMapper extends BaseMapper<UserWalletDetail> {
}
