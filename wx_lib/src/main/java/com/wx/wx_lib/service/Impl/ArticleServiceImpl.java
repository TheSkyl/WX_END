package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.wx.wx_lib.dao.ArticleDao;
import com.wx.wx_lib.dao.PoetrysDao;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.Poetrys;
import com.wx.wx_lib.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 小说文章主题
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

    @Autowired
    private ArticleDao mapper;

    @Autowired
    private PoetrysDao poetryDao;

    /**
     * 将list转换为map结构，key是小说id,value是章节集合
     * @return
     */
    @Override
    public Map<Integer, List<Article>> getAll(Integer type) {
        List<Article> articleList = mapper.selectList(new QueryWrapper<Article>().eq("type",type));
        Map<Integer, List<Article>> map = articleList.stream().collect(
                Collectors.toMap(Article::getNovelId, Lists::newArrayList,
                        (List<Article> newArticle, List<Article> oldArr) -> {
                            oldArr.addAll(newArticle);
                            return oldArr;
                        })
        );
        return map;
    }

    @Override
    public Map<Integer, List<Poetrys>> getAll() {
        List<Poetrys> articleList = poetryDao.selectList(null);
        Map<Integer, List<Poetrys>> map = articleList.stream().collect(
                Collectors.toMap(Poetrys::getAuthorId, Lists::newArrayList,
                        (List<Poetrys> newArticle, List<Poetrys> oldArr) -> {
                            oldArr.addAll(newArticle);
                            return oldArr;
                        })
        );
        return map;
    }
}
