package com.wx.wx_lib.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.wx_lib.model.Poems;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PoemsDao extends BaseMapper<Poems> {
}
