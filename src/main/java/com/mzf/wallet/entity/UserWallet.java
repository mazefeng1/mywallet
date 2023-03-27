package com.mzf.wallet.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户钱包
 * @author 好大雨
 * @create 2023/3/27 15:12
 */
@Data
@TableName("user_wallet")
public class UserWallet {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private Integer id;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "balance")
    private BigDecimal balance;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField(value = "version")
    private Integer version;
}
