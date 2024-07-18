package com.atguigu.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/8 11:23
 * @description
 */
@Configuration
public class RestTemplateConfig {
    //实例化 RestTemplate 实例
    @Bean
    @LoadBalanced   //赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
