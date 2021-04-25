package com.wx.authserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_role")
public class UserRole extends Object {

    @TableId(value = "user_id")
    private Integer userId;

    @TableId(value = "role_id")
    private String roleId;

    @TableId(value = "create_time")
    private Date createTime;

    private String creator;
}
