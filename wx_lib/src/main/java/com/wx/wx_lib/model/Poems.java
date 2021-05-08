package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("poems")
public class Poems {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("author_id")
    private String authorId;
    private String title;
    private String content;
    private String author;
}
