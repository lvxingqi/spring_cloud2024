package com.atguigu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/9 16:11
 * @description
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("rateLimit/byUrl")
    public String byUrl(){
        return "按rest地址限流测试ok";
    }

    @GetMapping("rateLimit/byResource")
    @SentinelResource(value = "byResourceSentinelResource",blockHandler = "handleBlockHandler")
    public String byResource(){
        return "按资源名称sentinelResource限流测试ok，O(∩_∩)O";
    }

    public String handleBlockHandler(BlockException blockException){
        return "服务不可用，触发了@SentinelResource，/(ㄒoㄒ)/~~"+blockException.getCause();
    }

    @GetMapping("/rateLimit/doAction/{p1}")
    @SentinelResource(value = "doAction",blockHandler = "doActionBlockHandler",
            fallback = "doActionFallback")
    public String doAction(@PathVariable("p1") Integer p1){
        if (p1==0){
            throw new RuntimeException("p1=0直接异常");
        }
        return "doAction";
    }

    public String doActionBlockHandler(@PathVariable("p1") Integer p1,BlockException e){
        log.error("sentinel配置自定义限流了:{}",e);
        return "sentinel配置自定义限流了";
    }

    public String doActionFallback(@PathVariable("p1") Integer p1,Throwable e){
        log.error("程序逻辑异常了");
        return "程序逻辑异常了\t"+e.getMessage();
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey",blockHandler = "testHotkeyBlockHandler")
    public String testHotkey(@RequestParam(value = "p1",required = false) String p1,
    @RequestParam(value = "p2",required = false) String p2){
        return "------------testHotkey";
    }

    public String testHotkeyBlockHandler(String p1,String p2,BlockException e){
        return "-----------testHotkeyBlockHandler";
    }

}
