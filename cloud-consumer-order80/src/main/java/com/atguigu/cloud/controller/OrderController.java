package com.atguigu.cloud.controller;

import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/5 16:16
 * @description
 */
@RestController
public class OrderController {
    @Value("${app.paymentUrl}")
    private String PaymentSrv_URL;
    @Resource
    private RestTemplate restTemplate;

    @PostMapping ("/consumer/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
        /*ResponseEntity<ResultData> responseEntity = restTemplate.exchange(
                PaymentSrv_URL + "/pay/del/",
                HttpMethod.POST,
                getHttpEntity(payDTO),
                ResultData.class
        );
        return responseEntity.getBody();*/
    }

    @DeleteMapping("/consumer/pay/del/{id}")
    public ResultData del(@PathVariable Integer id){
        ResponseEntity<ResultData> responseEntity = restTemplate.exchange(
                PaymentSrv_URL + "/pay/del/"+id,
                HttpMethod.DELETE,
                getHttpEntity(id),
                ResultData.class
        );
        return responseEntity.getBody();
    }

    public <T> HttpEntity<T> getHttpEntity(T data){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(data,headers);
    }
    @PutMapping("/consumer/pay/update")
    public ResultData update(@RequestBody PayDTO payDTO){
        ResponseEntity<ResultData> responseEntity = restTemplate.exchange(
                PaymentSrv_URL + "/pay/update",
                HttpMethod.PUT,
                getHttpEntity(payDTO),
                ResultData.class
        );
        return responseEntity.getBody();
    }

    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable Integer id){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id,ResultData.class,id);
    }

    @GetMapping("/consumer/pay/getPays")
    public ResultData getPays(Integer id){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/getPays",ResultData.class,id);
    }

    @GetMapping("/consumer/pay/get/info")
    public ResultData getPort(){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/info",ResultData.class);
    }
}
