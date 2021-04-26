package com.wx.wx_auth.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jwt工具类
 */
@Component
public class TokenManager {

    //设置token有效时常
    private long tokenExpiration = 24*60*60*1000;
    //编码密钥
    private String tokenSignKey = "asduaiosdu";

    //1.根据用户名生成token 通过jwt生成
    public String createToke (String username){
        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+tokenExpiration))//有效时长
                .signWith(SignatureAlgorithm.ES512,tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    //2.根据token字符串得到用户信息
    public String getUserInfoFromToken(String token){
        String userinfo = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
        return userinfo;
    }

    //3. 删除token
    public void removeToken(String token){

    }
}
