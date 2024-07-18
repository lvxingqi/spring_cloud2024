package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Order;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/18 9:47
 * @description
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GlobalTransactional(name = "aabbcc-create-order",rollbackFor = Exception.class)//AT
    @GetMapping("/order/create")
    public ResultData create(Order order){
        orderService.create(order);
        return ResultData.success(order);
    }
}
