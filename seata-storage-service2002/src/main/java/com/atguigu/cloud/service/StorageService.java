package com.atguigu.cloud.service;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/18 10:10
 * @description
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
