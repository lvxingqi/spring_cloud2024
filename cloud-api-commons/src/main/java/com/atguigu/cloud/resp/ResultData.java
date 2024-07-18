package com.atguigu.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/5 10:58
 * @description
 */
@Data
@Accessors(chain = true) //不要配置fluent=true选项，改变get，set命名方式后，会影响json序列化
public class ResultData<T> {
    private String code;
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        this.timestamp= System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data){
        ResultData<T> resultData=new ResultData<>();
        return resultData.setCode(ReturnCodeEnum.RC200.getCode())
                .setMessage(ReturnCodeEnum.RC200.getMessage())
                .setData(data);
    }

    public static <T> ResultData<T> fail(String code,String message){
        ResultData<T> resultData=new ResultData<>();
        return resultData.setCode(code).setMessage(message);
    }

    /**
     * 方法级别的类型参数，必须在返回值前标明类型参数，
     * 类级别的类型参数(标注在类上)，非静态方法可以直接使用，可以看成该类型参数属于类的变量，
     * 非静态方法就不能访问此变量，只能按照标准的泛型方法去写
     */
    public <E> void example(E e){

    }
}
