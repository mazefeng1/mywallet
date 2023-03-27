package com.mzf.wallet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author 好大雨
 * @create 2023/3/27 15:11
 */
@SpringBootApplication
@MapperScan("com.mzf.wallet.mapper")

public class WalletApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class,args);
    }
}
