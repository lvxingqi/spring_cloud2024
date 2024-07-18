package com.atguigu.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/9 11:02
 * @description
 */
@Service
public class FlowLimitService {
    @SentinelResource("common")
    public void common(){
        System.out.println("-------------FlowLimitService come in");
    }
}
