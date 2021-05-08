package com.wx.wx_auth.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.Poetrys;
import com.wx.wx_lib.service.PoetrysService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/poetrys")
public class PoetrysController {

    @Autowired
    private PoetrysService service;

    @GetMapping("/get")
    public UnifyResult getPoetry(){
        Page<Poetrys> page = new Page<>(1,150000);
        Poetrys list = service.getById(1);
        IPage<Poetrys> ll = service.page(page);
        System.out.println(list);
        return UnifyResult.ok().data("poetry",ll);
    }

    @GetMapping("/getByAuthor")
    public UnifyResult getByAuthor(String author){
        Map<String,Object> map = new HashMap<>();
        map.put("author", "李白");
        List<Poetrys> ll = service.listByMap(map);
//        System.out.println(list);
        return UnifyResult.ok().data("poetry",ll);
    }
}
