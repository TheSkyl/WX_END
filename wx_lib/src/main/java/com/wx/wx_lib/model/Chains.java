package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
@TableName("chains")
public class Chains {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String content;

}
