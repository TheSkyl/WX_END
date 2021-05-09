package com.wx.wx_lib.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.PoetryAuthorBanner;
import com.wx.wx_lib.model.Poetrys;

import java.util.List;
import java.util.Map;

public interface PoetryAuthorBannerService extends IService<PoetryAuthorBanner> {

    public List<PoetryAuthorBanner> getAll();

    public Map<String, List<Poetrys>> getAllPoetry(Integer type) ;
}
