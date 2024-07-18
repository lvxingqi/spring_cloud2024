package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/18 8:55
 * @description
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
