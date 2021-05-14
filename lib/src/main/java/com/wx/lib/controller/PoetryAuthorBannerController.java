package com.wx.lib.controller;

import com.wx.wx_lib.model.Banner;
import com.wx.wx_lib.model.PoetryAuthorBanner;
import com.wx.wx_lib.service.PoetryAuthorBannerService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poetryAuthorBanner")
public class PoetryAuthorBannerController {

    @Autowired
    private PoetryAuthorBannerService service;

    @RequestMapping("/page")
    public UnifyResult get(){
//        System.out.println(poetryAuthorBannerService.getAll().toString());
        return UnifyResult.ok().data("poetry",service.list());
    }

    @PostMapping("/add")
    public UnifyResult save(@Validated @RequestBody PoetryAuthorBanner banner){
        service.save(banner);
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
    public UnifyResult update(@Validated @RequestBody PoetryAuthorBanner banner){
        service.updateById(banner);
        return UnifyResult.ok();
    }
}
