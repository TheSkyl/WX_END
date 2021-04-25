package com.wx.wx_lib.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.wx_lib.model.CrudTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CrudTestDao extends BaseMapper<CrudTest> {
}
