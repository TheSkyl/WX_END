package com.wx.wx_auth.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.PoetryAuthor;
import com.wx.wx_lib.model.Poetrys;
import com.wx.wx_lib.service.PoetryAuthorService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/poetryAuthor")
public class PoetryAuthorController {

    @Autowired
    private PoetryAuthorService service;

    @GetMapping("/get")
    public UnifyResult getPoetry(){
//        Page<PoetryAuthor> page = new Page<>(1,150000);
//        PoetryAuthor list = service.getById(1);
        List<PoetryAuthor> ll = service.list(null);
//        System.out.println(list);
        return UnifyResult.ok().data("poetry",ll);
    }
}
