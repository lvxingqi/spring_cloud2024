package com.atguigu.cloud.controller;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/18 13:33
 * @description
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public ResultData decrease(@RequestParam("userId") Long userId,
                               @RequestParam("money") Long money){
        accountService.decrease(userId,money);
        return ResultData.success("扣减余额成功");
    }
}
