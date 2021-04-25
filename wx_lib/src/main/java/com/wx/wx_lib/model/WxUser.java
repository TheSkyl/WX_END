package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WxUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    private String mobile;

    private String openid;

    private String password;
    private String avatar;
    private String name;

    @TableField("create_time")
    private LocalDateTime createTime;
}
