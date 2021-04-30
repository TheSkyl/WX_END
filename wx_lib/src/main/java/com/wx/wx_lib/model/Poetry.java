package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("poetry")
public class Poetry {

    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 诗人
     */
    private String author;

    /**
     * 封面
     */
    private String imgLink;

    /**
     * 简介
     */
    @TableField("brief_introduction")
    private String briefIntroduction;

    @TableField(exist = false)
    private List<Article> children;
}
