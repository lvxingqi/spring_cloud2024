package com.atguigu.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/3 16:26
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDTO {
    private Integer id;
    //    支付流水号
    private String payNo;
    //    订单流水号
    private String orderNo;
    //   用户账号
    private Integer userId;
    //    交易金额
    private BigDecimal amount;
}
