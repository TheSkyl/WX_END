package com.test.wx_auth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.test.wx_auth.utils.HttpClientUtils;
import com.test.wx_lib.model.WxUser;
import com.test.wx_lib.service.WxUserService;
import com.test.wx_lib.utils.UnifyResult;
import com.test.wx_lib.utils.WxUtils;
import com.test.wx_lib.vo.WxLoginVO;
import com.test.wx_lib.wx.WxConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Wrapper;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private RedisTemplate redisTemplate;

//    @GetMapping("/wxLogin")
//    public UnifyResult wxLogin (String code, HttpSession session) throws Exception{
//        System.out.println(code);
//        String url = String.format(WxConstant.WX_LOGIN_CODE_URL,wxConstant.getAppid(),wxConstant.getSecret(),code);
//        String data = HttpClientUtils.get(url);
//        JSONObject res = JSON.parseObject(data);
//        System.out.println(res);
//        String session_key = (String) res.get("session_key");
//        String openid = (String) res.get("openid");
//
//        // 存入session 到redis
//
//
//        return UnifyResult.ok();
//    }

    @Autowired
    WxUserService service;

    @Autowired
    private WxConstant wxConstant;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping("/index")
    public String index(){

        return "hello index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "hello admin";
    }

    @GetMapping("/all")
    public String all(){
        return "hello admin and all";
    }

    @GetMapping("/role")
    public String role(){
        return "hello role";
    }

    @GetMapping("/update")
//    @Secured({"ROLE_admin","ROLE_sale"})
//    @PreAuthorize("hasAnyAuthority('admins')")
    public String update(){
        return "hello update";
    }

    @GetMapping("/auth")
    public UnifyResult test(String code, String encryptedData, String iv) throws Exception {
        System.out.println("测试请求");
        String url = String.format(WxConstant.WX_LOGIN_CODE_URL, wxConstant.getAppid(), wxConstant.getSecret(), code);
        String data = HttpClientUtils.get(url);
        JSONObject res = JSON.parseObject(data);
        System.out.println(res);
        String session_key = (String) res.get("session_key");
        String openid = (String) res.get("openid");
        WxLoginVO wxLoginVO = service.login(openid);

        return UnifyResult.ok().data("userInfo", wxLoginVO);
    }

    @GetMapping("/auths")
    public UnifyResult test(String code) throws Exception{
        System.out.println("测试请求");
        String url = String.format(WxConstant.WX_LOGIN_CODE_URL,wxConstant.getAppid(),wxConstant.getSecret(),code);
        String data = HttpClientUtils.get(url);
        JSONObject res = JSON.parseObject(data);
        System.out.println(res);
        String session_key = (String) res.get("session_key");
        String openid = (String) res.get("openid");
        WxLoginVO wxLoginVO = service.login(openid);

        log.info("openid",openid);

        return UnifyResult.ok().data("userInfo",wxLoginVO);
//        try {
//            String result = WxUtils.wxDecrypt(encryptedData,session_key,iv); //解密
//            JSONObject json = JSONObject.parseObject(result);
//            if (!json.containsKey("phoneNumber")){
//                throw new Exception("请求失败，用户未绑定手机号");
//            }
//            String phone = json.getString("phoneNumber");
//            if (StringUtils.isBlank(phone)){
//                throw new Exception("请求失败，用户未绑定手机号");
//            }
//            log.info("【openid】 = {}", openid);
//            log.info("【手机号】 = {}", phone);
//            WxLoginVO wxLoginVO = service.login(openid);
//
//            return UnifyResult.ok().data("userInfo",wxLoginVO);
//        }catch (Exception e){
//            throw new Exception("请求失败，用户未绑定手机号");
//        }
//        System.out.println(code);
//        return UnifyResult.ok().data("userInfo","ok");
    }
}
