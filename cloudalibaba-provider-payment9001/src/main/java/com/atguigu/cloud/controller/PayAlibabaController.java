package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/8 10:50
 * @description
 */
@RestController
public class PayAlibabaController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("pay/nacos/{id}")
    public String getPayInfo(@PathVariable("id") Integer id){
        return "nacos registry, serverPort:"+serverPort+"\t id:"+id;
    }

    //openfeign和sentinel进行服务降级和流量监控的整合case

    @GetMapping("/pay/nacos/get/{orderNo}")
    @SentinelResource(value = "getPayByOrderNo",blockHandler = "handleBlockHandler")
    public ResultData<String> getPayByOrderNo(@PathVariable String orderNo){
        PayDTO payDTO=new PayDTO();
        payDTO.setId(1024);
        payDTO.setOrderNo(orderNo);
        payDTO.setAmount(BigDecimal.valueOf(9.9));
        payDTO.setPayNo("pay:"+ IdUtil.simpleUUID());
        payDTO.setUserId(1);
        return ResultData.success("查询返回值："+payDTO);
    }

    public ResultData<String> handleBlockHandler(@PathVariable String orderNo, BlockException e){
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),
                "getPayByOrderNo服务不可用,触发sentinel流控配置规则"+
                        "\t"+"/(ㄒoㄒ)/~~");
    }
}
