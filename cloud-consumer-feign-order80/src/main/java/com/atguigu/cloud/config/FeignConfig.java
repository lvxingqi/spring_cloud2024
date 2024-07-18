package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/11 12:03
 * @description
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer myRetryer(){
        return Retryer.NEVER_RETRY;
//        return new Retryer.Default(100,1,3);
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
