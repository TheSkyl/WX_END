package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 诗的作者
 */
@Data
@TableName("poetry_author")
public class PoetryAuthor {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer name;

    private String intro;
    private String dynasty;
}
