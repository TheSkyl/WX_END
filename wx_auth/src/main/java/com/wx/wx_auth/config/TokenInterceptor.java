package com.wx.wx_auth.config;


import com.wx.wx_auth.exceptionhandler.UnauthorizedException;
import com.wx.wx_lib.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
public class TokenInterceptor implements HandlerInterceptor {

//    public static int i = Integer.parseInt(null);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");  //查询请求中是否携带token,不存在就不放行

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
