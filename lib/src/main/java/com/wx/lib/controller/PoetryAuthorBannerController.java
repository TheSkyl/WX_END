package com.wx.lib.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Banner;
import com.wx.wx_lib.model.Lunyu;
import com.wx.wx_lib.model.PoetryAuthorBanner;
import com.wx.wx_lib.service.PoetryAuthorBannerService;
import com.wx.wx_lib.utils.UnifyResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poetryAuthorBanner")
public class PoetryAuthorBannerController {

    @Autowired
    private PoetryAuthorBannerService service;

    @RequestMapping("/page")
    public UnifyResult get(Integer pageNum, Integer pageSize, String keyword){
        Page<PoetryAuthorBanner> page = new Page<>(pageNum,pageSize);
        //0查询小说，1查询名著，2查询诗词
        IPage<PoetryAuthorBanner> list = service.page(page);
        if (StringUtils.isNotEmpty(keyword)){
            System.out.println(keyword);
            list= service.page(page,new QueryWrapper<PoetryAuthorBanner>().like("name",keyword));
        }
        return UnifyResult.ok().data("poetryAuthor",list);
    }

    @PostMapping("/add")
    public UnifyResult save(@Validated @RequestBody PoetryAuthorBanner banner){
        service.save(banner);
        return UnifyResult.ok();
    }

    @GetMapping("/getById/{id}")
    public UnifyResult getById(@PathVariable Integer id){

        return UnifyResult.ok().data("poetryAuthor",service.getById(id));
    }

    @DeleteMapping("/delById/{id}")
    public UnifyResult delById(@PathVariable Integer id){
        service.removeById(id);
        return UnifyResult.ok();
    }

    @PutMapping("/update")
    public UnifyResult update(@Validated @RequestBody PoetryAuthorBanner banner){
        service.updateById(banner);
        return UnifyResult.ok();
    }
}
