package com.wx.wx_lib.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.FamousWorks;

import java.util.List;
import java.util.Map;

public interface FamousWorksService extends IService<FamousWorks> {

    public List<FamousWorks> getAll(Map<Integer, List<Article>> articleMap);

    public void deleteById(Integer id);
}
