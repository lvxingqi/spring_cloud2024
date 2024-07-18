package com.atguigu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/9 17:19
 * @description
 */
@RestController
@Slf4j
public class EmPowerController {
    @GetMapping("/empower")
    public String requestSentinel(){
        log.info("测试sentinel授权规则empower");
        return "sentinel授权规则";
    }
}
