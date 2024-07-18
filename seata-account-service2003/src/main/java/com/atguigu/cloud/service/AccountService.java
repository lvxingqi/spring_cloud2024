package com.atguigu.cloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/18 13:31
 * @description
 */
public interface AccountService {
    void decrease(Long userId, Long money);
}
