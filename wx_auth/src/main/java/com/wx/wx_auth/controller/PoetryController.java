package com.wx.wx_auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.Poetry;
import com.wx.wx_lib.model.PoetryAuthor;
import com.wx.wx_lib.model.Poetrys;
import com.wx.wx_lib.service.ArticleService;
import com.wx.wx_lib.service.PoetryAuthorService;
import com.wx.wx_lib.service.PoetryService;
import com.wx.wx_lib.service.PoetrysService;
import com.wx.wx_lib.utils.UnifyResult;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/poetry")
public class PoetryController {

    @Autowired
    private PoetryService service;

    @Autowired
    private PoetrysService poetrysService;
    @Autowired
    private PoetryAuthorService authorService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
//        Page<Novel> page = new Page<>(pageNum,pageSize);
        //0查询小说，1查询名著，2查询诗词
        Map<Integer, List<Article>> map = articleService.getAll(2);
        List<Poetry> list = service.getAll(map);
        return UnifyResult.ok().data("poetry",list);
    }

    @RequestMapping("/pagesss")
    public UnifyResult getAllByPages(Integer pageNum, Integer pageSize, String keyword){
//        Page<Novel> page = new Page<>(pageNum,pageSize);
        //0查询小说，1查询名著，2查询诗词
//        Map<Integer, List<Poetrys>> map = articleService.getAll();
        List<PoetryAuthor> list = authorService.list(new QueryWrapper<PoetryAuthor>().last("limit 6"));
        System.out.println(list.toString());
        return UnifyResult.ok().data("poetry",list);
    }

    @RequestMapping("/catalogue")
    public UnifyResult getCatalogue(String id){
        Map<String,Object> map = new Hashtable<>();
        map.put("author",id);
//        map.put("type",2);
        List<Poetrys> list = poetrysService.listByMap(map);
        return  UnifyResult.ok().data("catalogue",list);
    }

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
