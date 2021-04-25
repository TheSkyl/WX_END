package com.wx.wx_lib.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 轮播图对象 banner
 *
 * @author ruoyi
 * @date 2021-03-18
 */
@TableName("banner")
public class Banner  {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private String img;

    /**
     *
     */
    private String link;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String sequence;

    private Date createTime;

    /**
     * 状态
     */
    private String status;

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSequence() {
        return sequence;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", link='" + link + '\'' +
                ", name='" + name + '\'' +
                ", sequence='" + sequence + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}
