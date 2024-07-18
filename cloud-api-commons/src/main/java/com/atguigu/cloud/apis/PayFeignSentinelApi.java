package com.atguigu.cloud.apis;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback =PayFeignSentinelApiFallback.class )
public interface PayFeignSentinelApi {
    @GetMapping("/pay/nacos/get/{orderNo}")
    public ResultData<String> getPayByOrderNo(@PathVariable String orderNo);
}
