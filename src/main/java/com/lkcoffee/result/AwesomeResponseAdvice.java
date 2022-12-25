package com.lkcoffee.result;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@RestControllerAdvice
public class AwesomeResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(@NotNull MethodParameter returnType, @NotNull Class converterType) {
        if (StringHttpMessageConverter.class.isAssignableFrom(converterType)) {
            return false;
        }
        boolean ignore = false;
        IgnoreResponseAdvice ignoreResponseAdvice =
                returnType.getMethodAnnotation(IgnoreResponseAdvice.class);
        if (Objects.nonNull(ignoreResponseAdvice)) {
            ignore = ignoreResponseAdvice.value();
            return !ignore;
        }
        Class<?> clazz = returnType.getDeclaringClass();
        ignoreResponseAdvice = clazz.getDeclaredAnnotation(IgnoreResponseAdvice.class);
        RestController restController = clazz.getDeclaredAnnotation(RestController.class);
        if (Objects.nonNull(ignoreResponseAdvice)) {
            ignore = ignoreResponseAdvice.value();
        } else if (Objects.isNull(restController)) {
            ignore = true;
        }
        return !ignore;
    }

    @Override
    public Object beforeBodyWrite(Object body, @NotNull MethodParameter returnType, @NotNull MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        System.out.println(body);
        if (Objects.isNull(body)) {
            return Result.success();
        }
        if (body instanceof Result) {
            return body;
        }
        return Result.success(body);
    }
}