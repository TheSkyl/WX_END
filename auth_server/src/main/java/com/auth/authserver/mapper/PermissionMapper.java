package com.auth.authserver.mapper;

import com.auth.authserver.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper {

    @Select("SELECT p.`code` FROM `permission` p\t\n" +
            "LEFT JOIN role_permission rp ON rp.permission_id = p.id\n" +
            "LEFT JOIN role r on r.id = rp.role_id\n" +
            "LEFT JOIN user_role ur on ur.role_id= r.id\n" +
            "LEFT JOIN users u on u.id = ur.user_id\n" +
            " where u.id = #{id} ")
    List<Permission> selectByUserId(@Param("id")int id);
}
