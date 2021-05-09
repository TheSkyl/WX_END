package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.wx.wx_lib.dao.PoetryAuthorBannerDao;
import com.wx.wx_lib.dao.PoetrysDao;
import com.wx.wx_lib.model.PoetryAuthorBanner;
import com.wx.wx_lib.model.Poetrys;
import com.wx.wx_lib.service.PoetryAuthorBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PoetryAuthorBannerServiceImpl extends ServiceImpl<PoetryAuthorBannerDao, PoetryAuthorBanner> implements PoetryAuthorBannerService {

    @Autowired
    private PoetryAuthorBannerDao dao;

    @Autowired
    private PoetrysDao poetrysDao;

    /**
     * 将list转换为map结构，key是小说id,value是章节集合
     *
     * @return
     */
    @Override
    public Map<String, List<Poetrys>> getAllPoetry(Integer type) {
        List<Poetrys> articleList = poetrysDao.selectList(new QueryWrapper<Poetrys>().eq("type", type));
        Map<String, List<Poetrys>> map = articleList.stream().collect(
                Collectors.toMap(Poetrys::getAuthor, Lists::newArrayList,
                        (List<Poetrys> newArticle, List<Poetrys> oldArr) -> {
                            oldArr.addAll(newArticle);
                            return oldArr;
                        })
        );
        return map;
    }

    @Override
    public List<PoetryAuthorBanner> getAll() {
        List<PoetryAuthorBanner> poetryList = dao.selectList(null);
        Map<String, List<Poetrys>> map = new HashMap<>();
        for (PoetryAuthorBanner poetryAuthorBanner: poetryList){
            List<Poetrys> articleList = poetrysDao.selectList(new QueryWrapper<Poetrys>().eq("author", poetryAuthorBanner.getName()));
            map.put(poetryAuthorBanner.getName(),articleList);
        }

        poetryList.forEach(poetryAuthorBanner -> {
            if (map.containsKey(poetryAuthorBanner.getName())) {
                poetryAuthorBanner.setChildren(map.get(poetryAuthorBanner.getName()));
            }
        });
        return poetryList;
    }
}
