package com.wx.wx_lib.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.Poetry;

import java.util.List;
import java.util.Map;

public interface PoetryService extends IService<Poetry> {

    public List<Poetry> getAll(Map<Integer, List<Article>> articleMap);

    public void deleteById(Integer id);
}
