package org.lycoding.config;

import org.lycoding.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 将拦截器注入到ioc容器
 * 自定义拦截路径
 */

@Configuration
public class interceptConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        把登录拦截器注册到WebMvc容器，将拦截所有请求
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);
        interceptorRegistration.excludePathPatterns("/user/login","/user/register","/avator");//登录跟注册请求不拦截
    }
}
