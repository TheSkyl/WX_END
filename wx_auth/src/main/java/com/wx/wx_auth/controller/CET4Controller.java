package com.wx.wx_auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.CET4;
import com.wx.wx_lib.model.Poetrys;
import com.wx.wx_lib.service.CET4Service;
import com.wx.wx_lib.utils.UnifyResult;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cet4")
public class CET4Controller {

    @Autowired
    private CET4Service service;

    @GetMapping(value = "/get", produces = "application/json; charset=utf-8")
    public UnifyResult get(Integer pageNum, Integer pageSize,String author){

        Page<CET4> page = new Page<>(pageNum,pageSize);
//        Poetrys list = service.getById(1);
        IPage<CET4> list = service.page(page,new QueryWrapper<CET4>().eq("bookId",author));
//        System.out.println(list.getRecords().set);
        return UnifyResult.ok().data("poetry",list);
    }

}
