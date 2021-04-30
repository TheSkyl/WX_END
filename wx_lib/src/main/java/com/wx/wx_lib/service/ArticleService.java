package com.wx.wx_lib.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wx.wx_lib.model.Article;

import java.util.List;
import java.util.Map;


public interface ArticleService extends IService<Article> {

    public Map<Integer, List<Article>> getAll(Integer type);
}
