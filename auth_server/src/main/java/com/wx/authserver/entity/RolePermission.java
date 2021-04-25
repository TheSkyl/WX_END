package com.wx.authserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 权限 菜单关系表
 */
@Data
@TableName("role_permission")
public class RolePermission {

    @TableField("role_id")
    private String roleId;

    @TableField("permission_id")
    private String permissionId;

    public Object getPermissId() {
        return permissionId;
    }

}
