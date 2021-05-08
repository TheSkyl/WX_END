package com.wx.wx_auth.controller;

import com.wx.wx_lib.service.ShijingService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shijing")
public class ShijingController {

    @Autowired
    private ShijingService service;

    @GetMapping("/getAll")
    public UnifyResult getAll(){
        return UnifyResult.ok().data("shijing",service.list(null));
    }
}
