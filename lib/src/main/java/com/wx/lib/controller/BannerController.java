package com.wx.lib.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Banner;
import com.wx.wx_lib.service.BannerService;
import com.wx.wx_lib.utils.UnifyResult;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService service;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
        Page<Banner> page = new Page<>(1,2);
        IPage<Banner> iPage = service.page(page);
        return UnifyResult.ok().data("page",iPage);
    }

    @PostMapping("/add")
    public UnifyResult save(Banner banner){
        service.save(banner);
        return UnifyResult.ok();
    }

    @GetMapping("/getById/{id}")
    public UnifyResult getById(@PathVariable Integer id){

        return UnifyResult.ok().data("banner",service.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public UnifyResult delById(Integer id){
        service.removeById(id);
        return UnifyResult.ok();
    }

    @PutMapping("/update")
    public UnifyResult update(Banner banner){
        service.updateById(banner);
        return UnifyResult.ok();
    }

}
