package com.wx.lib.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Banner;
import com.wx.wx_lib.model.LearingBanner;
import com.wx.wx_lib.service.BannerService;
import com.wx.wx_lib.service.LearingBannerService;
import com.wx.wx_lib.utils.UnifyResult;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/learingbanner")
public class LearingBannerController {

    @Autowired
    private LearingBannerService service;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
        Page<LearingBanner> page = new Page<>(pageNum,pageSize);
        IPage<LearingBanner> iPage = service.page(page);
        return UnifyResult.ok().data("page",iPage);
    }

    @PostMapping("/add")
    public UnifyResult save(@Validated @RequestBody LearingBanner banner){
        service.save(banner);
        return UnifyResult.ok();
    }

    @GetMapping("/getById/{id}")
    public UnifyResult getById(@PathVariable Integer id){

        return UnifyResult.ok().data("banner",service.getById(id));
    }

    @DeleteMapping("/delById/{id}")
    public UnifyResult delById(@PathVariable Integer id){
        service.removeById(id);
        return UnifyResult.ok();
    }

    @PutMapping("/update")
    public UnifyResult update(@Validated @RequestBody LearingBanner banner){
        service.updateById(banner);
        return UnifyResult.ok();
    }

    @GetMapping("/change/{id}/status")
    public UnifyResult change(@Validated @RequestBody @PathVariable Integer id , @RequestParam Boolean status){
        LearingBanner banner = service.getById(id);
        banner.setBan(status);
        service.updateById(banner);
        return UnifyResult.ok();
    }
}
