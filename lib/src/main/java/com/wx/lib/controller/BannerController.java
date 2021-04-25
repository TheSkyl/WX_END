package com.wx.lib.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Banner;
import com.wx.wx_lib.service.BannerService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BannerController {

    @Autowired
    private BannerService service;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
        Page<Banner> page = new Page<>(1,2);
        IPage<Banner> iPage = service.page(page);
        return UnifyResult.ok().data("page",iPage);
    }

    @RequestMapping("/test")
    public UnifyResult getAllByPages(){
//        Page<Banner> page = new Page<>(pageNum,pageSize);
//        IPage<Banner> iPage = service.page(page);
        return UnifyResult.ok().data("page","test");
    }



}
