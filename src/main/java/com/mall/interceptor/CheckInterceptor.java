package com.mall.interceptor;

import com.mall.pojo.EnumResult;
import com.mall.pojo.ResultBean;
import com.mall.util.JsonUtil;
import com.mall.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author heavytiger
 * @version 1.0
 * @description 实现验证用户的headers中是否存在Authorization
 *              中的token，若不存在，返回状态码要求登录，存在放行
 * @date 2021/12/23 19:42
 */
public class CheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if(JwtUtil.verify(token)) {
            // 说明验证成功，允许访问资源
            return true;
        } else {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(JsonUtil.objToJson(new ResultBean<>(EnumResult.TOKEN_ERROR)));
            return false;
        }
    }
}
