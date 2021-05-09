package com.wx.lib.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Poetry;
import com.wx.wx_lib.model.Poetrys;
import com.wx.wx_lib.service.ArticleService;
import com.wx.wx_lib.service.PoetryAuthorBannerService;
import com.wx.wx_lib.service.PoetryService;
import com.wx.wx_lib.service.PoetrysService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poetrys")
public class PoetrysController {

    @Autowired
    private PoetrysService service;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private PoetryAuthorBannerService poetryAuthorBannerService;

//    @GetMapping("/page")
//    public UnifyResult get(){
//        System.out.println(poetryAuthorBannerService.getAll().toString());
//        return UnifyResult.ok().data("poetry",poetryAuthorBannerService.getAll());
//    }

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
        Page<Poetrys> page = new Page<>(pageNum,pageSize);
        //0查询小说，1查询名著，2查询诗词
        IPage<Poetrys> list = service.page(page);
        return UnifyResult.ok().data("poetry",list);
    }

    @PostMapping("/add")
    public UnifyResult save(@Validated @RequestBody Poetrys poetry){
        service.save(poetry);
        return UnifyResult.ok();
    }

    @GetMapping("/getById/{id}")
    public UnifyResult getById(@PathVariable Integer id){

        return UnifyResult.ok().data("poetry",service.getById(id));
    }

    @DeleteMapping("/delById/{id}")
    public UnifyResult delById(@PathVariable Integer id){
        service.removeById(id);
        return UnifyResult.ok();
    }

    @PutMapping("/update")
    public UnifyResult update(@Validated @RequestBody Poetrys poetry){
        service.updateById(poetry);
        return UnifyResult.ok();
    }
}
