package com.example.wangheng.advice;

import com.example.wangheng.exception.CustomiseException;
import com.example.wangheng.exception.ResponseVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wanngheng
 * @date 2023/4/13 23:06
 */
@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(CustomiseException.class)
    public ResponseVo customiseExceptionHandler(CustomiseException e) {
        return new ResponseVo(e.getCode(), e.getMsg(), e.getLog());
    }
}
