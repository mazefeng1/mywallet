package com.mzf.wallet.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户钱包明细
 * @author 好大雨
 * @create 2023/3/27 15:13
 */
@Data
@TableName("user_wallet_detail")
public class UserWalletDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private Integer id;

    @TableField(value = "user_id")
    private Integer userId;


    @TableField(value = "trade_amount")
    private BigDecimal tradeAmount;

    @TableField(value = "trade_type")
    private Integer tradeType;

    @TableField(value = "trade_time")
    private LocalDateTime tradeTime;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;


}
