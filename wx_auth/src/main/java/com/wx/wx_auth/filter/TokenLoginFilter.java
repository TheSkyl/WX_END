package com.wx.wx_auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wx.wx_auth.exceptionhandler.UnauthorizedException;
import com.wx.wx_auth.security.TokenManager;
import com.wx.wx_lib.utils.JwtUtils;
import io.jsonwebtoken.SignatureException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class TokenLoginFilter implements HandlerInterceptor {

    // token 操作
    private TokenManager tokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<>();
        //获取请求头的令牌
        String token = request.getHeader("token");

        try {
            String id = JwtUtils.getTokenInfo(token);
            if (StringUtils.isBlank(id)){
                throw new UnauthorizedException("无效的token");
            }
            map.put("msg","请求成功");
            map.put("state",true);
            return true; //放行
        } catch (SignatureException e) {
            e.printStackTrace();
            map.put("msg","无效签名！");
        }
        map.put("state",false);
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
