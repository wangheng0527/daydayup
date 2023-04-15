package com.example.wangheng.advice;

import com.example.wangheng.exception.CustomiseException;
import com.example.wangheng.exception.ExceptionEnum;
import com.example.wangheng.exception.ResponseVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author wanngheng
 * @date 2023/4/13 22:49
 */
@RestControllerAdvice(basePackages = {"com.example.wangheng.controller"})
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // response是ResultVo类型，或者注释了NotControllerResponseAdvice都不进行包装
        return !returnType.getParameterType().isAssignableFrom(ResponseVo.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // String类型不能直接包装
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                // 将数据包装在ResultVo里后转换为json串进行返回
                return mapper.writeValueAsString(new ResponseVo(body));
            } catch (JsonProcessingException e) {
                throw new CustomiseException(ExceptionEnum.RESPONSE_PACKAGE_EXCEPTION);
            }
        }
        // 否则直接包装成ResultVo返回
        return new ResponseVo(body);
    }
}
