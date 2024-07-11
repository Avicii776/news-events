package org.lycoding.exception;

import org.lycoding.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//全局异常处理器，用于处理全局抛出异常的格式信息

/**
 * 通过@ControllerAdvice注解可以将对于控制器的全局配置放在同一个位置。
 * 注解了@RestControllerAdvice的类的方法可以使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上。
 * @RestControllerAdvice注解将作用在所有注解了@RequestMapping的控制器的方法上。
 */
@RestControllerAdvice   //控制类增强

public class GlobalException {
    @ExceptionHandler   //指定当前需要拦截的异常——Exception表示不可控的异常
    public Result handlerException(Exception e){
        e.printStackTrace();
//        如果程序抛出异常且存在异常信息则按要求的json格式抛出异常，否则抛出异常信息为“操作失败”
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败！！！");
    }
}
