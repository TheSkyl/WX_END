package com.wx.lib.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.Banner;


import com.wx.wx_lib.model.Novel;
import com.wx.wx_lib.service.ArticleService;
import com.wx.wx_lib.service.INovelService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/novel")
public class NovelController {

    @Autowired
    private INovelService service;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
//        Page<Novel> page = new Page<>(pageNum,pageSize);
        //0查询小说，1查询名著，2查询诗词
        Map<Integer, List<Article>> map = articleService.getAll(0);
        List<Novel> list = service.getAll(map);
        return UnifyResult.ok().data("novel",list);
    }

    @PostMapping("/add")
    public UnifyResult save(@Validated @RequestBody Novel novel){
        service.save(novel);
        return UnifyResult.ok();
    }

    @GetMapping("/getById/{id}")
    public UnifyResult getById(@PathVariable Integer id){

        return UnifyResult.ok().data("novel",service.getById(id));
    }

    @DeleteMapping("/delById/{id}")
    public UnifyResult delById(@PathVariable Integer id){
        service.deleteById(id);
        return UnifyResult.ok();
    }

    @PutMapping("/update")
    public UnifyResult update(@Validated @RequestBody Novel banner){
        service.updateById(banner);
        return UnifyResult.ok();
    }
}
