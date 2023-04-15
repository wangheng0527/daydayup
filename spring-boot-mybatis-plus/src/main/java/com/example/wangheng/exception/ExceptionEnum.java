package com.example.wangheng.exception;

import lombok.Getter;

/**
 * @author wanngheng
 * @date 2023/4/13 22:36
 */
@Getter
public enum ExceptionEnum implements StatusCode {

    /**
     * 请求成功
     */
    SUCCESS("200", "请求成功"),

    /**
     * 公共异常：TSP001****
     */
    RESPONSE_PACKAGE_EXCEPTION("TSP0010001", "返回结果包装异常"),
    ACCESS_DATABASE_EXCEPTION("TSP0010002", "访问数据库异常"),

    /**
     * 用户模块：TSP002****
     */
    USER_NOT_FOUND_EXCEPTION("TSP0020001", "指定用户未找到");

    private final String code;

    private final String msg;

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
