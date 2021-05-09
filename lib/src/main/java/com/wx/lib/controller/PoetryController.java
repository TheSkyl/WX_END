package com.wx.lib.controller;

import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.FamousWorks;
import com.wx.wx_lib.model.Poetry;
import com.wx.wx_lib.service.ArticleService;
import com.wx.wx_lib.service.PoetryAuthorBannerService;
import com.wx.wx_lib.service.PoetryService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/poetry")
public class PoetryController {

    @Autowired
    private PoetryService service;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private PoetryAuthorBannerService poetryAuthorBannerService;

    @GetMapping("/page")
    public UnifyResult get(){
        System.out.println(poetryAuthorBannerService.getAll().toString());
        return UnifyResult.ok().data("poetry",poetryAuthorBannerService.getAll());
    }

//    @RequestMapping("/page")
//    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
////        Page<Novel> page = new Page<>(pageNum,pageSize);
//        //0查询小说，1查询名著，2查询诗词
//        Map<Integer, List<Article>> map = articleService.getAll(2);
//        List<Poetry> list = service.getAll(map);
//        return UnifyResult.ok().data("poetry",list);
//    }

    @PostMapping("/add")
    public UnifyResult save(@Validated @RequestBody Poetry poetry){
        service.save(poetry);
        return UnifyResult.ok();
    }

    @GetMapping("/getById/{id}")
    public UnifyResult getById(@PathVariable Integer id){

        return UnifyResult.ok().data("poetry",service.getById(id));
    }

    @DeleteMapping("/delById/{id}")
    public UnifyResult delById(@PathVariable Integer id){
        service.deleteById(id);
        return UnifyResult.ok();
    }

    @PutMapping("/update")
    public UnifyResult update(@Validated @RequestBody Poetry poetry){
        service.updateById(poetry);
        return UnifyResult.ok();
    }
}
