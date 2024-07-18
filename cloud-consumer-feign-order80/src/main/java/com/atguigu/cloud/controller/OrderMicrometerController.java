package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/12 15:16
 * @description
 */
@RestController
public class OrderMicrometerController {
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/feign/micrometer/{id}")
    public String a(@PathVariable("id") Integer id){
        return payFeignApi.myMicrometer(id);
    }
}
