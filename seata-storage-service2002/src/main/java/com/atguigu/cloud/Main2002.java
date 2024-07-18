package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/18 10:37
 * @description
 */
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.atguigu.cloud.mapper")
public class Main2002 {
    public static void main(String[] args) {
        SpringApplication.run(Main2002.class,args);
    }
}
