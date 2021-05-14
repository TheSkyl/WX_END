package com.wx.wx_lib.model;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import springfox.documentation.spring.web.json.Json;

@Data
@TableName(value = "cet4",autoResultMap = true)
public class CET4 {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("headWord")
    private String headWord;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private JSONObject content;
    @TableField("bookId")
    private String bookId;

    @TableField(exist = false)
    private String bookName;

    @TableField(exist = false)
    private String contentValue;

}
