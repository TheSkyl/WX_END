package com.wx.authserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        System.out.println("test");
        return "index1212121212";
    }
}
