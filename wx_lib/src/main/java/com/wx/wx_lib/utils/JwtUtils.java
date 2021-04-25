package com.wx.wx_lib.utils;

import com.sun.deploy.net.HttpResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpRequest;

import java.util.Date;

public class JwtUtils {

    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7; //过期时间
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pz@FfWcs2jZWLPHa"; //密钥

    /**
     * 创建 token并返回
     * @param id 用户id
     * @param name 用户名字
     * @param avatarUrl 用户头像
     * @return
     */
    public static String createToken(String id, String name,String avatarUrl){
        String token = Jwts.builder()
                .setHeaderParam("typ","jwt")
                .setHeaderParam("alg", "HS256")
                .claim("id",id) //id
                .claim("name",name) //姓名
                .claim("avatarUrl",avatarUrl) //图片地址
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APP_SECRET)
                .compact();

        return token;
    }

    /**
     * 验证是否合法
     * @return
     */
    public static void parserToken(String token){
        Claims parse= Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
    }

    /**
     * 获取 token 信息
     */
    public static String getTokenInfo(String token){
        if (StringUtils.isBlank(token)) return "";
        Claims parse= Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();

        return (String) parse.get("id");
    }
}
