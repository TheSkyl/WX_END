package com.wx.authserver.mapper;

import com.wx.authserver.entity.RolePermission;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RolePermissionMapper extends BaseMapper {

    @Select("select rp.permission_id from  role_permission rp left join role r on r.id = rp.role_id ${ew.customSqlSegment}  ")
    List<RolePermission> selectById(@Param(Constants.WRAPPER) Wrapper wrapper);
}
