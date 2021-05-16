package com.wx.authserver.config;

import com.wx.authserver.entity.Users;
import com.wx.authserver.mapper.UsersMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Autowired
    private UsersMapper mapper;

    /**
     * 想JWT 中添加额外用户信息
     * @param oAuth2AccessToken
     * @param oAuth2Authentication
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        QueryWrapper<Users> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("username",oAuth2Authentication.getName());
        System.out.println(oAuth2Authentication.getName());
        Users users = mapper.selectOne(objectQueryWrapper);
        Map<String,Object> map = new HashMap<>();
        map.put("id", users.getId());

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(map);
        return oAuth2AccessToken;
    }
}
