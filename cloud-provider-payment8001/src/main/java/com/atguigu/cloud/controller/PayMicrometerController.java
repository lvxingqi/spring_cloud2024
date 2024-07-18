package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/12 15:05
 * @description
 */
@RestController
public class PayMicrometerController {

    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id){
        return "欢迎来到 myMicrometer inputId:    " + id+"\t  服务返回："+ IdUtil.simpleUUID();
    }

}
