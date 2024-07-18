package com.atguigu.cloud.controller;

import com.atguigu.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/8 17:25
 * @description
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "----------------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "----------------testB";
    }
    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/testC")
    public String testC(){
        flowLimitService.common();
        return "----------------testC";
    }

    @GetMapping("/testD")
    public String testD(){
        flowLimitService.common();
        return "----------------testD";
    }

    @GetMapping("/testE")
    public String testE() throws InterruptedException {
        System.out.println(System.currentTimeMillis()+"\t"+"testE,排队等");
        Thread.sleep(new Random().nextInt(210));
        return "----------------testE";
    }

    public static void main(String[] args) {
        Random random=new Random();
        int n=0;
        for (int i=0;i<100;i++){
            if (random.nextInt(210)>200){
                n++;
            }
        }
        System.out.println(n);
        double h=n/100.0;
        System.out.println(h);
        //测算出大概100次请求，超时200ms请求的比例约占10%
    }
}
