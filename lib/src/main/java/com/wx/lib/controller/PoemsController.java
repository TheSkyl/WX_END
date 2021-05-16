package com.wx.lib.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Poems;
import com.wx.wx_lib.model.Poetrys;
import com.wx.wx_lib.model.Shijing;
import com.wx.wx_lib.service.PoemsService;
import com.wx.wx_lib.service.ShijingService;
import com.wx.wx_lib.utils.UnifyResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poems")
public class PoemsController {

    @Autowired
    private PoemsService service;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
        Page<Poems> page = new Page<>(pageNum,pageSize);
        //0查询小说，1查询名著，2查询诗词
        IPage<Poems> list = service.page(page);
        if (StringUtils.isNotEmpty(keyword)){
            System.out.println(keyword);
            list= service.page(page,new QueryWrapper<Poems>().like("title",keyword));
        }
        return UnifyResult.ok().data("poems",list);
    }

    @PostMapping("/add")
    public UnifyResult save(@Validated @RequestBody Poems poems){
        service.save(poems);
        return UnifyResult.ok();
    }

    @GetMapping("/getById/{id}")
    public UnifyResult getById(@PathVariable Integer id){

        return UnifyResult.ok().data("poems",service.getById(id));
    }

    @DeleteMapping("/delById/{id}")
    public UnifyResult delById(@PathVariable Integer id){
        service.removeById(id);
        return UnifyResult.ok();
    }

    @PutMapping("/update")
    public UnifyResult update(@Validated @RequestBody Poems poems){
        service.updateById(poems);
        return UnifyResult.ok();
    }
}
