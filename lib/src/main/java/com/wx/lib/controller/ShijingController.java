package com.wx.lib.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Poetrys;
import com.wx.wx_lib.model.Shijing;
import com.wx.wx_lib.service.ShijingService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shijing")
public class ShijingController {

    @Autowired
    private ShijingService service;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
        Page<Shijing> page = new Page<>(pageNum,pageSize);
        //0查询小说，1查询名著，2查询诗词
        IPage<Shijing> list = service.page(page);
        return UnifyResult.ok().data("shijing",list);
    }

    @PostMapping("/add")
    public UnifyResult save(@Validated @RequestBody Shijing shijing){
        service.save(shijing);
        return UnifyResult.ok();
    }

    @GetMapping("/getById/{id}")
    public UnifyResult getById(@PathVariable Integer id){

        return UnifyResult.ok().data("shijing",service.getById(id));
    }

    @DeleteMapping("/delById/{id}")
    public UnifyResult delById(@PathVariable Integer id){
        service.removeById(id);
        return UnifyResult.ok();
    }

    @PutMapping("/update")
    public UnifyResult update(@Validated @RequestBody Shijing shijing){
        service.updateById(shijing);
        return UnifyResult.ok();
    }
}
