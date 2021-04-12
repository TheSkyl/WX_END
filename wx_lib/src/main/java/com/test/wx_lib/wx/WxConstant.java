package com.test.wx_lib.wx;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("wx.login")
public class WxConstant {

    private String appid;
    private String secret;

    public static final String AES="AES";
    public static final String AES_CBC_PADDING = "AES/CBC/PKCS7Padding";
    //微信请求地址
    public static final String WX_LOGIN_CODE_URL = "https://api.weixin.qq.com/sns/jscode2session" + "?appid=%s" + "&secret=%s" + "&js_code=%s" + "&grant_type=authorization_code";
    //获取accessToken 接口
    public static final String WX_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%S&secret=%S";

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public static String getAES() {
        return AES;
    }

    public static String getAesCbcPadding() {
        return AES_CBC_PADDING;
    }

    public static String getWxLoginCodeUrl() {
        return WX_LOGIN_CODE_URL;
    }

    public static String getWxAccessToken() {
        return WX_ACCESS_TOKEN;
    }
}
