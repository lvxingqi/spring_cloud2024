package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.mapper.AccountMapper;
import com.atguigu.cloud.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/18 13:32
 * @description
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Override
    public void decrease(Long userId, Long money) {
        accountMapper.decrease(userId,money);
        // int a=10/0;
        myTimeout();
    }

    /**
     * 模拟超时异常
     */
    public void myTimeout(){
        try{
            TimeUnit.SECONDS.sleep(65);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
