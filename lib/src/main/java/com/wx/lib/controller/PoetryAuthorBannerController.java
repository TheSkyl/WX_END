package com.wx.lib.controller;

import com.wx.wx_lib.service.PoetryAuthorBannerService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poetryAuthorBanner")
public class PoetryAuthorBannerController {

    @Autowired
    private PoetryAuthorBannerService service;

    @GetMapping("/get")
    public UnifyResult get(){
        System.out.println(service.getAll().toString());
        return UnifyResult.ok().data("test",service.getAll());
    }
}
