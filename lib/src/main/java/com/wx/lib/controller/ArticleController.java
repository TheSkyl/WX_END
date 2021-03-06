package com.wx.lib.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.Banner;
import com.wx.wx_lib.service.ArticleService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
        Page<Article> page = new Page<>(pageNum,pageSize);
        IPage<Article> iPage = service.page(page,new QueryWrapper<Article>().eq("type",keyword));
        return UnifyResult.ok().data("article",iPage);
    }

    @PostMapping("/add")
    public UnifyResult save(@Validated @RequestBody Article article){
        service.save(article);
        return UnifyResult.ok();
    }

    @GetMapping("/getById/{id}")
    public UnifyResult getById(@PathVariable Integer id){
        return UnifyResult.ok().data("article",service.getById(id));
    }

    @DeleteMapping("/delById/{id}")
    public UnifyResult delById(@PathVariable Integer id){
        service.removeById(id);
        return UnifyResult.ok();
    }

    @PutMapping("/update")
    public UnifyResult update(@Validated @RequestBody Article article){
        service.updateById(article);
        return UnifyResult.ok();
    }
}
