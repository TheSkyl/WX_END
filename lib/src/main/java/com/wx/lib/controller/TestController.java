package com.wx.lib.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

//    @PreAuthorize("hasAnyAuthority('ROLE_p1')") //拥有p1才可以访问
    @GetMapping("/index")
    public String index(){

        return "index";
    }
}
