package com.wx.wx_auth.config;


import com.wx.wx_auth.exceptionhandler.UnauthorizedException;
import com.wx.wx_lib.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");  //查询请求中是否携带token,不存在就不放行
        System.out.println("拦截去求求你了");
        try {
            String id = JwtUtils.getTokenInfo(token);       //不存在则为无效
            if (StringUtils.isBlank(id)){
                throw new UnauthorizedException("无效token");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setHeader("msg","User not logged in");
        response.setStatus(401);
        return false;
    }
}
