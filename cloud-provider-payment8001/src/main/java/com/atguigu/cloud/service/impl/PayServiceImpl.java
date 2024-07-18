package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/3 16:38
 * @description
 */
@Component
public class PayServiceImpl implements PayService {
    @Resource
    private PayMapper paymapper;
    @Override
    public int add(Pay pay) {
        return paymapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return paymapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return paymapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return paymapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return paymapper.selectAll();
    }
}
