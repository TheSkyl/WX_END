package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("shijing")
public class Shijing {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String chapter;
    private String section;
    private String content;
}
