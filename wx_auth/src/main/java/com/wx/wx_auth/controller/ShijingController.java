package com.wx.wx_auth.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Lunyu;
import com.wx.wx_lib.model.Shijing;
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

    @GetMapping("/page")
    public UnifyResult getPoetryPage(Integer pageNum, Integer pageSize,String author){
        Page<Shijing> page = new Page<>(pageNum,pageSize);
//        Poetrys list = service.getById(1);
        IPage<Shijing> ll = service.page(page);
//        System.out.println(list);
        return UnifyResult.ok().data("poetry",ll);
    }
}
