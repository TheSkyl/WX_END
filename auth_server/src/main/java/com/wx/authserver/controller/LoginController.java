package com.wx.authserver.controller;

import com.wx.authserver.util.UnifyResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends BaseApiController{

    @RequestMapping("/userInfo")
    public UnifyResult userInfo(){

        return UnifyResult.ok().data("user",user);
    }
}
