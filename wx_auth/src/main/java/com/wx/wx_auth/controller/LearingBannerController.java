package com.wx.wx_auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.FamousWorks;
import com.wx.wx_lib.model.LearingBanner;
import com.wx.wx_lib.service.LearingBannerService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/learingbanner")
public class LearingBannerController {

    @Autowired
    private LearingBannerService service;

    @RequestMapping("/page")
    public UnifyResult getAllByPage(Integer pageNum, Integer pageSize, String keyword){
//        Page<Novel> page = new Page<>(pageNum,pageSize);
        //0查询小说，1查询名著，2查询诗词
//        Map<Integer, List<Article>> map = articleService.getAll(1);
        List<LearingBanner> list = service.list(new QueryWrapper<LearingBanner>().eq("ban",1).orderByDesc("sequence"));
        return UnifyResult.ok().data("learingbanner",list);
    }

    @RequestMapping("/pageAll")
    public UnifyResult getAllByPageAll(Integer pageNum, Integer pageSize, String keyword){
        Page<LearingBanner> page = new Page<>(pageNum,pageSize);
        //0查询小说，1查询名著，2查询诗词
//        Map<Integer, List<Article>> map = articleService.getAll(1);
        IPage<LearingBanner> list = service.page(page,new QueryWrapper<LearingBanner>().eq("ban",1));
        return UnifyResult.ok().data("poetry",list);
    }
}
