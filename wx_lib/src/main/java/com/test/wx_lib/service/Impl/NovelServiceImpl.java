package com.test.wx_lib.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.wx_lib.dao.NovelMapper;
import com.test.wx_lib.model.Novel;
import com.test.wx_lib.service.INovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 小说Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-09
 */
@Service
public class NovelServiceImpl extends ServiceImpl<NovelMapper, Novel> implements INovelService {
    @Autowired
    private NovelMapper novelMapper;

//    /**
//     * 查询小说
//     *
//     * @param id 小说ID
//     * @return 小说
//     */
//    @Override
//    public Novel selectNovelById(Long id) {
//        return novelMapper.selectNovelById(id);
//    }
//
//    /**
//     * 查询小说列表
//     *
//     * @param novel 小说
//     * @return 小说
//     */
//    @Override
//    public List<Novel> selectNovelList(Novel novel) {
//        return novelMapper.selectNovelList(novel);
//    }
//
//    /**
//     * 新增小说
//     *
//     * @param novel 小说
//     * @return 结果
//     */
//    @Override
//    public int insertNovel(Novel novel) {
//        novel.setCreateTime(DateUtils.getNowDate());
//        return novelMapper.insertNovel(novel);
//    }
//
//    /**
//     * 修改小说
//     *
//     * @param novel 小说
//     * @return 结果
//     */
//    @Override
//    public int updateNovel(Novel novel) {
//        return novelMapper.updateNovel(novel);
//    }
//
//    /**
//     * 删除小说对象
//     *
//     * @param ids 需要删除的数据ID
//     * @return 结果
//     */
//    @Override
//    public int deleteNovelByIds(String ids) {
//        return novelMapper.deleteNovelByIds(Convert.toStrArray(ids));
//    }
//
//    /**
//     * 删除小说信息
//     *
//     * @param id 小说ID
//     * @return 结果
//     */
//    @Override
//    public int deleteNovelById(Long id) {
//        return novelMapper.deleteNovelById(id);
//    }
}
