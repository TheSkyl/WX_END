package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("poetry_author_banner")
public class PoetryAuthorBanner {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String intro;
    private String dynasty;
    @TableField(exist = false)
    private List<Poetrys> children;
}
