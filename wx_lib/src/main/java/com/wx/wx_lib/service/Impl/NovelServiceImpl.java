package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.ArticleDao;
import com.wx.wx_lib.dao.NovelMapper;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.Novel;
import com.wx.wx_lib.service.INovelService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 小说Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-09
 */
@Service
public class NovelServiceImpl extends ServiceImpl<NovelMapper, Novel> implements INovelService {

    @Autowired
    ArticleDao articleDao;

    /**
     * 先查询所有小说，将二级结果封装到一级的节点中，形成树结构目录
     *
     * @param articleMap key是对应小说的id,value对应小说的章节集合
     * @return
     */
    @Override
    public List<Novel> getAll(Map<Integer, List<Article>> articleMap) {
        List<Novel> novelList = baseMapper.selectList(null);
        novelList.forEach(novelLists -> {
            if (articleMap.containsKey(novelLists.getId())) {
                System.out.println(articleMap.get(novelLists.getId()));
                novelLists.setChildren(articleMap.get(novelLists.getId()));
            }
        });
        return novelList;
    }

    @Override
    public void deleteById(Integer id) {
        articleDao.delete(new QueryWrapper<Article>().eq("novel_id",id));
        baseMapper.deleteById(id);
    }

}
