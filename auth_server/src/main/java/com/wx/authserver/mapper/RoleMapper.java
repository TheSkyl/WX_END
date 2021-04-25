package com.wx.authserver.mapper;

import com.wx.authserver.entity.Role;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper {

    @Select("select r.id from role r left join user_role ur on r.id = ur.role_id ${ew.customSqlSegment}  ")
    List<Role> selectById(@Param(Constants.WRAPPER) Wrapper wrapper);
}
