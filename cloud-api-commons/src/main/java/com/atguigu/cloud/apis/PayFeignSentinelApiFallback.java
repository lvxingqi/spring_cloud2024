package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/15 15:38
 * @description
 */
@Component
public class PayFeignSentinelApiFallback implements PayFeignSentinelApi{
    @Override
    public ResultData<String> getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "对方服务宕机或不可用，服务降级fallback/(ㄒoㄒ)/~~");
    }
}
