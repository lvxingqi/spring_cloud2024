package com.atguigu.cloud.controller;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/18 10:33
 * @description
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public ResultData decrease(@RequestParam("productId") Long productId,
                               @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        return ResultData.success("扣减库存成功");
    }
}
