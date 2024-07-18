package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/12 9:06
 * @description
 */
@RestController
public class PayGateWayController {

    @Resource
    private PayService payService;
    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData<Pay> getPayById(@PathVariable("id") Integer id){
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getInfo(){
        return ResultData.success("gateway test info:"+ IdUtil.simpleUUID());
    }

    @GetMapping(value = "/pay/gateway/filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request){
        StringBuilder result= new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headName = headerNames.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println("请求头名："+headName+",请求头值："+headValue);
            if (headName.equalsIgnoreCase("X-Request-atguigu1")
            ||headName.equalsIgnoreCase("X-Request-atguigu2")){
                result.append(headName).append("\t").append(headValue).append(" ");
            }
        }
        return ResultData.success("getGateWayFilter 过滤器 test:"+ result+"\t"+ DateUtil.now());
    }
}
