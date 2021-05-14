package com.wx.wx_auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Poems;
import com.wx.wx_lib.model.Poetrys;
import com.wx.wx_lib.service.PoemsService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poems")
public class PoemsController {

    @Autowired
    private PoemsService service;

    @GetMapping("/pageAll")
    public UnifyResult getPoetryPage(Integer pageNum, Integer pageSize){
        Page<Poems> page = new Page<>(pageNum,pageSize);
        IPage<Poems> ll = service.page(page);
        return UnifyResult.ok().data("poetry",ll);
    }
}
