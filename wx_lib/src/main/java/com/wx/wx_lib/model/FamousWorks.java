package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName("famous_works")
public class FamousWorks {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 书名
     */
    private String title;

    /**
     * 作者
     */
    private String author;
    /**
     * 总章节
     */
    @TableField("count_chapter")
    private String countChapter;
    /**
     * 加入时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 简介
     */
    @TableField("brief_introduction")
    private String briefIntroduction;
    /**
     * 封面
     */
    @TableField("img_link")
    private String imgLink;
    /**
     * 非存储字段
     */
    @TableField(exist = false)
    private List<Article> children;
}
