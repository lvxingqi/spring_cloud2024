package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/3 17:10
 * @description
 */
@RestController
@Slf4j
@Tag(name ="支付模块",description = "随便写点")
public class PayServiceController {
    @Resource
    private PayService payService;
    @Operation(summary="新增支付流水")
    @PostMapping("/pay/add")
    public ResultData<String> addPay(@RequestBody PayDTO payDTO){
        log.info(payDTO.toString());
        Pay pay=new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int i = payService.add(pay);
        return ResultData.success("插入成功,返回值:"+i);
    }

    @Operation(summary="删除支付流水",description = "根据主键删除流水记录")
    @DeleteMapping("/pay/del/{id}")
    public ResultData<Integer> delPay(@PathVariable("id") Integer id){
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @Operation(summary="更新支付流水",description = "根据主键更新流水记录")
    @PutMapping("/pay/update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        log.info(payDTO.toString());
        Pay pay=new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int i = payService.update(pay);
        return ResultData.success("修改成功,返回值:"+i);
    }

    @Operation(summary="查询支付流水",description = "根据主键查询流水记录")
    @GetMapping(value = "/pay/get/{id}")
    public ResultData<Pay> getPayById(@PathVariable("id") Integer id) throws InterruptedException{
        TimeUnit.SECONDS.sleep(20);
        if (id==-4) throw new RuntimeException("id不能为负数");
        log.info(id.toString());
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @Operation(summary="查询支付流水",description = "查询所有的支付流水记录")
    @GetMapping("/pay/getPays")
    public ResultData<List<Pay>> getPays(){
        return ResultData.success(payService.getAll());
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/get/info")
    public ResultData<String> getInfo(@Value("${atguigu.info}") String atguiguInfo){
        return ResultData.success("atguiguInfo:"+atguiguInfo+"\tport:"+port);
    }
}
