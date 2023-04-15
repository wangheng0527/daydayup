package com.example.wangheng.exception;

import lombok.Data;

/**
 * @author wanngheng
 * @date 2023/4/13 22:38
 */
@Data
public class ResponseVo {

    private String code;

    private String msg;

    private Object data;

    public ResponseVo(Object data) {
        this.code = ExceptionEnum.SUCCESS.getCode();
        this.msg = ExceptionEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public ResponseVo(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
