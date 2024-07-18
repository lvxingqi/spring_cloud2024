package com.atguigu.cloud.apis;

import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/11 8:53
 * @description
 */
//@FeignClient(value = "cloud-payment-service")
@FeignClient(value = "cloud-gateway")
public interface PayFeignApi {
    @PostMapping("/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    @GetMapping(value = "/pay/get/{id}")
    public ResultData getPayById(@PathVariable("id") Integer id);

    @GetMapping("/pay/get/info")
    public ResultData getInfo();
    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData getId(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getInfoA();

}
