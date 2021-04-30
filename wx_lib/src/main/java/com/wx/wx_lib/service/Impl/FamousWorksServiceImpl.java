package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.ArticleDao;
import com.wx.wx_lib.dao.FamousWorksDao;
import com.wx.wx_lib.dao.NovelMapper;
import com.wx.wx_lib.model.Article;
import com.wx.wx_lib.model.FamousWorks;
import com.wx.wx_lib.model.Novel;
import com.wx.wx_lib.service.FamousWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FamousWorksServiceImpl extends ServiceImpl<FamousWorksDao, FamousWorks> implements FamousWorksService {

    @Autowired
    private ArticleDao articleDao;
    /**
     * 先查询所有名著，将二级结果封装到一级的节点中，形成树结构目录
     *
     * @param articleMap key是对应小说的id,value对应小说的章节集合
     * @return
     */
    @Override
    public List<FamousWorks> getAll(Map<Integer, List<Article>> articleMap) {
        List<FamousWorks> famousWorksList = baseMapper.selectList(null);
//        novelList.get(0).setChildren(articleMap.get(64));
//        for (int i = 0; i < novelList.size(); i++) {
//            if (articleMap.containsKey(novelList.get(i).getId()) == true){
//                novelList.get(i).setChildren(articleMap.get(novelList.get(i).getId()));
//            }
//        }
        famousWorksList.forEach(novelLists -> {
            if (articleMap.containsKey(novelLists.getId())) {
                System.out.println(articleMap.get(novelLists.getId()));
                novelLists.setChildren(articleMap.get(novelLists.getId()));
            }
        });
        return famousWorksList;
    }

    @Override
    public void deleteById(Integer id) {
        articleDao.delete(new QueryWrapper<Article>().eq("novel_id",id));
        baseMapper.deleteById(id);
    }
}
