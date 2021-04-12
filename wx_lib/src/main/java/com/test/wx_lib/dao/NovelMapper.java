package com.test.wx_lib.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.wx_lib.model.Novel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 小说Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-09
 */
@Mapper
public interface NovelMapper extends BaseMapper<Novel> {
    /**
     * 查询小说
     *
     * @param id 小说ID
     * @return 小说
     */
    public Novel selectNovelById(Long id);

    /**
     * 查询小说列表
     *
     * @param novel 小说
     * @return 小说集合
     */
    public List<Novel> selectNovelList(Novel novel);

    /**
     * 新增小说
     *
     * @param novel 小说
     * @return 结果
     */
    public int insertNovel(Novel novel);

    /**
     * 修改小说
     *
     * @param novel 小说
     * @return 结果
     */
    public int updateNovel(Novel novel);

    /**
     * 删除小说
     *
     * @param id 小说ID
     * @return 结果
     */
    public int deleteNovelById(Long id);

    /**
     * 批量删除小说
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNovelByIds(String[] ids);
    }
