package com.wx.authserver.mapper;

import com.wx.authserver.entity.UserRole;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRoleMapper extends BaseMapper {

    @Select("SELECT p.`code` FROM `permission` p\t\n" +
            "LEFT JOIN role_permission rp ON rp.permission_id = p.id\n" +
            "LEFT JOIN role r on r.id = rp.role_id\n" +
            "LEFT JOIN user_role ur on ur.role_id= r.id\n" +
            "LEFT JOIN users u on u.id = ur.user_id\n" +
            " ${ew.customSqlSegment}  ")
    List<UserRole> selectById(@Param(Constants.WRAPPER) Wrapper wrapper);
}
