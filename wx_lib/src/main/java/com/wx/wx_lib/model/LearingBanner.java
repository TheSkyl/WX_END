package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("learing_banner")
public class LearingBanner {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    //0小说，1名著，2诗，3论语，4诗经
    private String type;
    /**
     * 图片地址
     */
    @TableField("img_link")
    private String imgLink;

    private String sequence;
    private Boolean ban;
}
