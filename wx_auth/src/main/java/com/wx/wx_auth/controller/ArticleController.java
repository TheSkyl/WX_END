package com.wx.wx_auth.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.service.ArticleService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
        Page<Article> page = new Page<>(pageNum,pageSize);
        IPage<Article> iPage = service.page(page);
        return UnifyResult.ok().data("page",iPage);
    }

    @RequestMapping("/catalogue")
    public UnifyResult getCatalogue(Integer id,String type){
        Map<String,Object> map = new Hashtable<>();
        map.put("novel_id",id);
        map.put("type",type);
        List<Article> list = service.listByMap(map);
        return  UnifyResult.ok().data("catalogue",list);
    }

    @PostMapping("/add")
    public UnifyResult save(@Validated @RequestBody Article article){
        service.save(article);
        return UnifyResult.ok();
    }

    @GetMapping("/getById")
    public UnifyResult getById(Integer id){
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
