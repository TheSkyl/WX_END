package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("poems_author")
public class PoemsAuthor {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    @TableField("intro_l")
    private String introL;
    @TableField("intro_s")
    private String introS;
}
