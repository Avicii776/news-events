package org.lycoding.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.lycoding.utils.JwtUtil;
import org.lycoding.utils.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * 登录拦截器 ：验证该用户是否已经登录，判断该用户是否具备某些操作的权限
 * 验证某请求请求头中携带的Authorization字段为token值
 * Authorization为空则代表用户信息过期，即为登录，若不为空则是一段token值，可以从其中获得用户信息
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> map = JwtUtil.parseToken(token);
            ThreadLocalUtil.set(map);
//            拦截请求通过，放行
            return true;
        } catch (Exception e) {
//            拦截请求不通过，不放行
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        清空ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}