package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignSentinelApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/8 11:25
 * @description
 */
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/pay/nacos/{id}")
    public String echoAppName(@PathVariable("id") String id){
        System.out.println(id);
        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        String result=restTemplate.getForObject(serverURL+"/pay/nacos/"+id,String.class,id);
        return result+"\t"+"我是OrderNacosController83的调用者..........";
    }

//    =============================================//
    @Resource
    private PayFeignSentinelApi payFeignSentinelApi;

    @GetMapping("/consumer/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable String orderNo){
        return payFeignSentinelApi.getPayByOrderNo(orderNo);
    }

}
