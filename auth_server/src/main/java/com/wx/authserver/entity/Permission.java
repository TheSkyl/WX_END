package com.wx.authserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 菜单表
 */
@Data
@TableName("permission")
public class Permission {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String code;

    private String description;

    private String url;
}
