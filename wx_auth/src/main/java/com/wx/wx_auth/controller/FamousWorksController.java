package com.wx.wx_auth.controller;

import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.FamousWorks;
import com.wx.wx_lib.service.ArticleService;
import com.wx.wx_lib.service.FamousWorksService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("famousWorks")
public class FamousWorksController {

    @Autowired
    private FamousWorksService service;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
//        Page<Novel> page = new Page<>(pageNum,pageSize);
        //0查询小说，1查询名著，2查询诗词
        Map<Integer, List<Article>> map = articleService.getAll(1);
        List<FamousWorks> list = service.getAll(map);
        return UnifyResult.ok().data("famousWorks",list);
    }

    @PostMapping("/add")
    public UnifyResult save(@Validated @RequestBody FamousWorks famousWorks){
        service.save(famousWorks);
        return UnifyResult.ok();
    }

    @GetMapping("/getById/{id}")
    public UnifyResult getById(@PathVariable Integer id){

        return UnifyResult.ok().data("famousWorks",service.getById(id));
    }

    @DeleteMapping("/delById/{id}")
    public UnifyResult delById(@PathVariable Integer id){
        service.deleteById(id);
        return UnifyResult.ok();
    }

    @PutMapping("/update")
    public UnifyResult update(@Validated @RequestBody FamousWorks famousWorks){
        service.updateById(famousWorks);
        return UnifyResult.ok();
    }
}
