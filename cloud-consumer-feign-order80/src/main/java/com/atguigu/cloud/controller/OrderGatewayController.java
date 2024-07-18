package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/12 15:39
 * @description
 */
@RestController
public class OrderGatewayController {
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/feign/gateway/get/{id}")
    public ResultData getId(@PathVariable Integer id){
        return payFeignApi.getId(id);
    }

    @GetMapping(value = "/feign/gateway/info")
    public ResultData<String> getInfoA(){
        return payFeignApi.getInfoA();
    }
}
