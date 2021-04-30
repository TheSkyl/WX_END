package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.ArticleDao;
import com.wx.wx_lib.dao.PoetryDao;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.FamousWorks;
import com.wx.wx_lib.model.Poetry;
import com.wx.wx_lib.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PoetryServiceImpl extends ServiceImpl<PoetryDao, Poetry> implements PoetryService {
    @Autowired
    private ArticleDao articleDao;
    /**
     * 先查询所有名著，将二级结果封装到一级的节点中，形成树结构目录
     *
     * @param articleMap key是对应小说的id,value对应小说的章节集合
     * @return
     */
    @Override
    public List<Poetry> getAll(Map<Integer, List<Article>> articleMap) {
        List<Poetry> poetryList = baseMapper.selectList(null);
//        novelList.get(0).setChildren(articleMap.get(64));
//        for (int i = 0; i < novelList.size(); i++) {
//            if (articleMap.containsKey(novelList.get(i).getId()) == true){
//                novelList.get(i).setChildren(articleMap.get(novelList.get(i).getId()));
//            }
//        }
        poetryList.forEach(novelLists -> {
            if (articleMap.containsKey(novelLists.getId())) {
                novelLists.setChildren(articleMap.get(novelLists.getId()));
            }
        });
        return poetryList;
    }

    @Override
    public void deleteById(Integer id) {
        articleDao.delete(new QueryWrapper<Article>().eq("novel_id",id));
        baseMapper.deleteById(id);
    }
}
