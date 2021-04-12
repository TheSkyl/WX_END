package com.test.wx_auth.config;


import com.test.wx_auth.exceptionhandler.UnauthorizedException;
import com.test.wx_lib.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TokenInterceptor implements HandlerInterceptor {

//    public static int i = Integer.parseInt(null);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

        try {
            String id = JwtUtils.getTokenInfo(token);
//            if (StringUtils.isBlank(id)){
//                throw new UnauthorizedException("无效token");
//            }
//            i = Integer.parseInt(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setHeader("msg","User not logged in");
        response.setStatus(401);
        return false;
    }
}
