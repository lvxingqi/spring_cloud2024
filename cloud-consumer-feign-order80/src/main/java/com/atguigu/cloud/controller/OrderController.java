package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/11 9:04
 * @description
 */
@RestController
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        System.out.println("第一步：模拟本地addOrder新增订单成功，省略sql操作");
        System.out.println("第二步：再开启addPay支付微服务远程调用");
        return payFeignApi.addPay(payDTO);
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        ResultData pay=null;
        try{
            System.out.println(DateUtil.now());
            pay= payFeignApi.getPayById(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(DateUtil.now());
        }
        return pay;
    }

    @GetMapping("/feign/pay/mylb")
    public ResultData getMylb(){
        return payFeignApi.getInfo();
    }
}
