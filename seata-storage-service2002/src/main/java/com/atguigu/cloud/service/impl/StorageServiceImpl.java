package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.mapper.StorageMapper;
import com.atguigu.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/18 10:13
 * @description
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------> storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------> storage-service中扣减库存结束");
    }
}
