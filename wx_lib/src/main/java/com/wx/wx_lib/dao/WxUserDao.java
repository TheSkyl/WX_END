package com.wx.wx_lib.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wx.wx_lib.model.WxUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface WxUserDao extends BaseMapper<WxUser> {

    @Select("select * from wx_user ${ew.customSqlSegment}")
    Optional<WxUser> selectByOne(@Param(Constants.WRAPPER) Wrapper wrapper);
}
