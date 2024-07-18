package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @author 吕星琪
 * @version 1.10 2024/7/3 16:13
 * @description
 */
@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper")
@RefreshScope
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class,args);
    }
}
