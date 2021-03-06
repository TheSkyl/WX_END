package com.wx.lib.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.CET4;
import com.wx.wx_lib.service.CET4Service;
import com.wx.wx_lib.utils.UnifyResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cet4")
public class CET4Controller {

    @Autowired
    private CET4Service service;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
        Page<CET4> page = new Page<>(pageNum,pageSize);
        //0查询小说，1查询名著，2查询诗词
        IPage<CET4> list = service.page(page);
        if (StringUtils.isNotEmpty(keyword)){
            System.out.println(keyword);
            list= service.page(page,new QueryWrapper<CET4>().like("headWord",keyword));
        }

        return UnifyResult.ok().data("cetList",list);
    }

    @PostMapping("/add")
    public UnifyResult save(@RequestBody CET4 cet4){
        service.save(cet4);
        return UnifyResult.ok();
    }

    @GetMapping("/getById/{id}")
    public UnifyResult getById(@PathVariable Integer id){
        return UnifyResult.ok().data("cetList",service.getById(id));
    }

    @DeleteMapping("/delById/{id}")
    public UnifyResult delById(@PathVariable Integer id){
        service.removeById(id);
        return UnifyResult.ok();
    }

    @PutMapping("/update")
    public UnifyResult update(@Validated @RequestBody CET4 cet4){
        service.updateById(cet4);
        return UnifyResult.ok();
    }
}
