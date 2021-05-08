package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Cy")
public class Cy {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String spell;
    private String content;
    private String derivation;
    private String samples;
}
