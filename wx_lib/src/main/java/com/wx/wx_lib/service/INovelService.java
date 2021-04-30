package com.wx.wx_lib.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.Novel;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

/**
 * 小说Service接口
 *
 * @author ruoyi
 * @date 2021-04-09
 */
public interface INovelService extends IService<Novel> {
    public List<Novel> getAll(Map<Integer,List<Article>> map);

    public void deleteById(Integer id);
}
