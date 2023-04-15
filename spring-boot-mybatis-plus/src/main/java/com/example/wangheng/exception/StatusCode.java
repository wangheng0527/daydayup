package com.example.wangheng.exception;

/**
 * @author wanngheng
 * @date 2023/4/13 22:33
 */
public interface StatusCode {

    /**
     * 获取异常状态码
     * @return 异常状态码
     */
    String getCode();

    /**
     * 获取异常信息
     * @return 异常信息
     */
    String getMsg();
}
