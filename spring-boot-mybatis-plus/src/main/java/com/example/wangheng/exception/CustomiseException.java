package com.example.wangheng.exception;

import lombok.Getter;

/**
 * @author wanngheng
 * @date 2023/4/13 22:59
 */
@Getter
public class CustomiseException extends RuntimeException {

    private final String code;

    private final String msg;

    private final String log;

    public CustomiseException(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
        this.log = null;
    }

    public CustomiseException(ExceptionEnum exceptionEnum, String log) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
        this.log = log;
    }
}
