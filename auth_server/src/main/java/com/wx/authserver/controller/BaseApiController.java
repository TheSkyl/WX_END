package com.wx.authserver.controller;


import com.wx.authserver.entity.Users;
import com.wx.authserver.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

@Slf4j
public abstract class BaseApiController {

    @Autowired
    UsersMapper usersMapper;

    protected Users user;
    protected String uid;


    /**
     * 自定义CustomerAccessTokenConverter 这个类的作用主要用于AccessToken的转换，
     * 默认使用DefaultAccessTokenConverter 这个装换器
     * DefaultAccessTokenConverter有个UserAuthenticationConverter，这个转换器作用是把用户的信息放入token中，
     * 默认只是放入username
     * <p>
     * 自定义了下这个方法，加入了额外的信息
     * <p>
     */
    @ModelAttribute
    public void getSessionUser(Authentication authentication) {
        if (authentication != null && authentication.getDetails() != null) {
            Object details = authentication.getDetails();
            if (details instanceof OAuth2AuthenticationDetails) {
                OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) details;
                log.info(oAuth2AuthenticationDetails.getTokenValue());
                log.info(authentication.getName());
                Map<String, Object> decodedDetails = (Map<String, Object>) oAuth2AuthenticationDetails
                        .getDecodedDetails();
                if (null != decodedDetails) {
                    log.info(decodedDetails.toString());
                    log.info("BaseController", "sessuserid: " + decodedDetails.get("id"));
                    uid = String.valueOf( decodedDetails.get("id")) ;
                    if (StringUtils.isNotBlank(uid)) {
                        log.info("BaseController getSessionUser uid:" + uid);
                        user = usersMapper.selectById(uid);
                    }
                }
            }
        }
    }

}
