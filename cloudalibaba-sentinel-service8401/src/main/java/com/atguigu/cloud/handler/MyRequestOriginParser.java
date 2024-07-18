package com.atguigu.cloud.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/9 17:23
 * @description
 */
@Component
public class MyRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        //此处参数名由程序的这里去指定，随便叫什么都可以
        return request.getParameter("abc");
    }
}
